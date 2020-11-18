package com.almaz.examples

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainViewModel : ViewModel() {
    private val jokeInteractor = JokeInteractor()
    val jokeLiveData = MutableLiveData<Joke>()

    fun getNewJoke() {
        jokeInteractor.getNewJoke()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {
                jokeLiveData.postValue(it)
            }, {
                it.printStackTrace()
            }
            )
    }
}
