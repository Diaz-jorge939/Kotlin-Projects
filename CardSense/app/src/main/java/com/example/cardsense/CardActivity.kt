package com.example.cardsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsense.adapter.CardAdapter
import com.example.cardsense.Model.Card
import com.example.cardsense.Model.Deck
import com.example.cardsense.databinding.ActivityCardBinding
import com.google.gson.Gson


class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding

    lateinit var flashcards : List<Card>
    lateinit var adapter : CardAdapter

//    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val deckReceived = intent.getStringExtra("DECK_CLICKED")
        val deck = Gson().fromJson(deckReceived, Deck::class.java)

        //flashcards = deck.getDeck()
        adapter = CardAdapter(deck.getDeck())

        binding.flashcardRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.flashcardRecyclerview.adapter = adapter

        adapter.onItemClick = {
//           Toast.makeText(this, "${it.getFront()}", Toast.LENGTH_SHORT).show()
        }
        binding.cardCardview.setOnClickListener{
//            deck.addCard(Card("Question", "Answer"))
//            deck.display()
//            adapter.notifyItemInserted(deck.getSize()-1)
        }


    }

}