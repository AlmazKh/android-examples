package com.almaz.examples.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.almaz.examples.Joke
import com.almaz.examples.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_jokes_list.view.*

// Это private val jokesLambda: (Joke) -> Unit ВАЖНО и НУЖНО для того, чтобы можно было получать дата класс во фрагменте
class JokesListAdapter(private val jokesLambda: (Joke) -> Unit) :
    RecyclerView.Adapter<JokesListAdapter.JokesViewHolder>() {

    // теперь это не в конструкторе, а просто как приватное поле
    private var jokesList: List<Joke> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder =
        JokesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_jokes_list, parent, false)
        )

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(jokesList[position])
        // тут мы отслеживаем нажатие на элемент списка
        holder.itemView.setOnClickListener {
            // это значение при нажатии будет выбрасываться JokesListFragment
            jokesLambda.invoke(jokesList[position])
        }
    }

    // обязательно переопределять, т.к список с данными храниться в поле jokesList
    override fun getItemCount(): Int = jokesList.size

    // вызываем, когда нужно передать данные адаптеру
    fun submitList(list: List<Joke>) {
        jokesList = list
    }

    class JokesViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(joke: Joke) {
            itemView.tv_joke_id.text = joke.id
            itemView.tv_joke_text.text = joke.text
        }
    }
}

/*
class JokesListAdapter(private val jokesLambda: (Joke) -> Unit) :
    ListAdapter<Joke, JokesListAdapter.JokesViewHolder>(JokesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder =
        JokesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_jokes_list, parent, false)
        )

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            // это значение при нажатии будет выбрасываться JokesListFragment
            jokesLambda.invoke(getItem(position))
        }
    }

    class JokesViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(joke: Joke) {
            itemView.tv_joke_id.text = joke.id
            itemView.tv_joke_text.text = joke.text
        }
    }

    // пока этот класс тупо переписываем и подставляем свой дата класс
    class JokesDiffCallback : DiffUtil.ItemCallback<Joke>() {
        override fun areItemsTheSame(
            oldItem: Joke,
            newItem: Joke
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Joke,
            newItem: Joke
        ): Boolean = oldItem == newItem
    }
}
*/
