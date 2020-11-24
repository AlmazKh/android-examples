package com.almaz.examples.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.almaz.examples.Joke
import com.almaz.examples.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_jokes_list.view.*

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
