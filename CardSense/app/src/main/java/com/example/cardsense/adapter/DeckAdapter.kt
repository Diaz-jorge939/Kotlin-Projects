package com.example.cardsense.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardsense.R
import org.w3c.dom.Text

class DeckAdapter:  RecyclerView.Adapter<DeckAdapter.DeckViewHolder>(){
    // private val dataset: List<Deck>
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
//        val item = dataset[position]
//        holder.textView.text = context.resources.getString(item.stringResourceId)
//        holder.imageView.setImageResource(item.imageResourceId)
    }
    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
        TODO("Not yet implemented")
        //return dataset.size
    }
}