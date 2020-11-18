package com.almaz.examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_joke.setOnClickListener {
            viewModel.getNewJoke()
        }
        observeJokeLiveData()
    }

    private fun observeJokeLiveData() {
        return viewModel.jokeLiveData.observe(this, Observer {
            it?.let {
                tv_joke.text = it.text
            }
        })
    }
}
