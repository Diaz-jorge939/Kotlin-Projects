package com.example.cardsense.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cardsense.R
import com.example.cardsense.data.Deck

class DeckAdapter(
    private var dataset: List<Deck>

    ) : RecyclerView.Adapter<DeckAdapter.DeckViewHolder>(){

//    private var onClickListener: OnClickListener? = null
    var onItemClick : ((Deck) -> Unit)? = null

    class DeckViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        // deck name
        val title: TextView = view.findViewById(R.id.deck_title)

        // number of cards in deck
        val card_num: TextView = view.findViewById(R.id.deck_card_count)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeckViewHolder {
        // almost always the same code in any application
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.deck_item, parent, false)

        return DeckViewHolder(adapterLayout)
    }
    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: DeckViewHolder, position: Int) {

        val item = dataset[position]
        holder.title.text = item.getDeckName()
        holder.card_num.text = item.getCardCount().toString()

//        holder.itemView.setOnClickListener {
//            if (onClickListener != null) {
//                onClickListener!!.onClick(position, item)
//            }
//        }
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
//
//    // A function to bind the onclickListener.
//    fun setOnClickListener(onClickListener: OnClickListener) {
//        this.onClickListener = onClickListener
//    }
//
//    // onClickListener Interface
//    interface OnClickListener {
//        fun onClick(position: Int, deck: Deck)
//    }

}