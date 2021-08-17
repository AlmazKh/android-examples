package com.almaz.examples.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.almaz.examples.R
import kotlinx.android.synthetic.main.fragment_jokes_list.*

class JokesListFragment : BaseFragment() {

    private val viewModel = JokesListViewModel()

    private val jokesAdapter = JokesListAdapter {
        // тут мы полчаем то, что выплюнули при нажатии в адаптере
        // берем эти данные и передаем в другой фрагмент и сами идем туда
        rootActivity.navController.navigate(
            R.id.action_jokesListFragment_to_jokeDetailsFragment, bundleOf("joke" to it)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_jokes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getJokesList()

        rv_jokes.layoutManager = LinearLayoutManager(context)
        rv_jokes.adapter = jokesAdapter

        observeJokesLiveData()
    }

    private fun observeJokesLiveData() {
        return viewModel.jokesLiveData.observe(rootActivity, Observer {
            jokesAdapter.submitList(it)
            jokesAdapter.notifyDataSetChanged()
        })
    }
}