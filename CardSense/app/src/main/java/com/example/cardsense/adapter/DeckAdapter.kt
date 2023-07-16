package com.example.cardsense.adapter

import android.view.*
import android.view.View.OnCreateContextMenuListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cardsense.R
import com.example.cardsense.Model.Deck

class DeckAdapter(private var dataset: List<Deck>) : RecyclerView.Adapter<DeckAdapter.DeckViewHolder>(){

    var onItemClick : ((Deck) -> Unit)? = null

    class DeckViewHolder(private val view: View) : RecyclerView.ViewHolder(view), OnCreateContextMenuListener{
        // deck name
        val title: TextView = view.findViewById(R.id.deck_title)

        // number of cards in deck
        val card_num: TextView = view.findViewById(R.id.deck_card_count)

        // float context menu for item in recycler view
        val popup_options: ImageView = view.findViewById(R.id.menu_options)

        override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {

            menu?.add(adapterPosition,101,0,"Add Card")
            menu?.add(adapterPosition,102,1,"Add Deck")
            menu?.add(adapterPosition,103,2,"Edit Deck Name")
        }
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

        holder.popup_options.setOnCreateContextMenuListener(holder)

        holder.title.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }


    fun shuffle(){
        dataset = dataset.shuffled()
        notifyDataSetChanged()
    }

}