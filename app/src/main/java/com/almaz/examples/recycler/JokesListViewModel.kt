package com.almaz.examples.recycler

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.almaz.examples.Joke
import com.almaz.examples.JokeInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class JokesListViewModel : ViewModel() {
    private val jokeInteractor = JokeInteractor()
    val jokesLiveData = MutableLiveData<List<Joke>>()

    fun getJokesList() {
        jokeInteractor.getJokesList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                // закидываем в лайвдату при успешном выполнении
                // у нас в данном случае запрос не идет, поэтому всегда будет этот вариант
                jokesLiveData.postValue(it)
            }, {
                // обработка ошибки
            })
    }
}
