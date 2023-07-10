package com.example.cardsense.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardsense.R
import com.example.cardsense.data.Card

class CardAdapter(private var flashcards: List<Card>) : RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    // lamda function
    // ((card) -> Unit)? declared a function type that recieves a Card argument and returns Unit
    // Unit is similar to void in java (doesnt return anything)
    // nullable function set to null. can later be reassigned to new function i.e in activity_card
    var onItemClick : ((Card) -> Unit)? = null

    class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textview: TextView = view.findViewById(R.id.card_question)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return CardViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val item = flashcards[position]
        //holder.textview.text = item.getFront()

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return flashcards.size
    }
}