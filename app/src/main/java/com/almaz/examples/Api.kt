package com.almaz.examples

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers

interface Api {
    @GET("/")
    @Headers("Accept: application/json")
    fun getRandomJoke(): Observable<Joke>
}
