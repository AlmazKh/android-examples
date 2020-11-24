package com.almaz.examples.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.almaz.examples.R
import com.almaz.examples.recycler.ContainerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_get_joke.setOnClickListener {
            viewModel.getNewJoke()
        }

        btn_go_to_recycler.setOnClickListener {
            startActivity(Intent(this, ContainerActivity::class.java))
            finish()
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
