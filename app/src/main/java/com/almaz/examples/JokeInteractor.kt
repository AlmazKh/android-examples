package com.almaz.examples

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://icanhazdadjoke.com/"

class JokeInteractor {
    private var api: Api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Api::class.java)

    fun getNewJoke(): Single<Joke> {
        return Single.fromObservable(api.getRandomJoke())
    }

    fun getJokesList(): Single<List<Joke>> {
        return Single.just(
            listOf(
                Joke("1", "joke 1", 200),
                Joke("2", "joke 2", 200),
                Joke("3", "joke 3", 200),
                Joke("4", "joke 4", 200),
                Joke("5", "joke 5", 200)
            )
        )
    }
}
