package com.example.cardsense


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsense.adapter.DeckAdapter
import com.example.cardsense.data.Deck
import com.example.cardsense.databinding.ActivityMainBinding
import java.io.Serializable

class MainActivity : AppCompatActivity(){
    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods in MainActivity class.
    private lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"
    var count = 0
    val dataset = mutableListOf<Deck>()
    val adapter = DeckAdapter(dataset)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityMainBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)

        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerview.adapter = adapter


        binding.mainFab.setOnClickListener {

            dataset.add(Deck("Flashcard ${count++}"))
            adapter.notifyItemInserted(dataset.size-1)
            Log.d(TAG, "onClick: works")
        }

        adapter.onItemClick = {
            Intent(this, FlashcardActivity::class.java).also{
                it.putExtra("DECK_DATA",it)
            }
//            Toast.makeText(this, "${it.getDeckName()}", Toast.LENGTH_SHORT).show()
        }
    }

}