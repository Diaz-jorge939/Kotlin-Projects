package com.example.cardsense

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        // dialog box displays
        // start - begins a study game that records right or wrong answers
        // shuffle - shuffles cards
        val options = arrayOf("start", "shuffle")
        val optionsDialog = AlertDialog.Builder(this)
            .setTitle("Options")
            .setSingleChoiceItems(options, 0){dialogInterface, i ->
                Toast.makeText(this@CardActivity, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Ok"){_,_ ->
                Toast.makeText(this@CardActivity, "Ok", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Done"){_,_ ->
                Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
            }

        val deckReceived = intent.getStringExtra("DECK_CLICKED")
        val deck = Gson().fromJson(deckReceived, Deck::class.java)

        flashcards = deck.getDeck()
        adapter = CardAdapter(flashcards)

        binding.flashcardRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.flashcardRecyclerview.adapter = adapter

        adapter.onItemClick = {
            val intent = Intent(this@CardActivity, StartActivity::class.java)
            intent.putExtra("CARD_CLICKED",it.getBack())
            startActivity(intent)
        }
        
        binding.cardActivityFab.setOnClickListener{
//            adapter.shuffle()
            optionsDialog.show()
        }
    }
}