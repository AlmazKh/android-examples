package com.almaz.examples.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.almaz.examples.Joke
import com.almaz.examples.R
import kotlinx.android.synthetic.main.fragment_joke_details.*

class JokeDetailsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_joke_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*Принимаем данные, которые мы отправили с помощью метода
        rootActivity.navController.navigate(
            R.id.action_jokesListFragment_to_jokeDetailsFragment, bundleOf("joke" to it)
        )
        из фрагмента JokesListFragment
        отправили с ключом "joke" в бандле по этому ключу здесь и вытаскиваем*/
        arguments?.getParcelable<Joke>("joke")?.let {
            tv_joke_id.text = it.id
            tv_joke_text.text = it.text
            tv_status.text = it.status.toString()
        }
    }
}