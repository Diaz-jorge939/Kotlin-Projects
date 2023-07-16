package com.example.cardsense

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsense.adapter.DeckAdapter
import com.example.cardsense.Model.Deck
import com.example.cardsense.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity(){
    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods in MainActivity class.
    private lateinit var binding: ActivityMainBinding

    var dataset : MutableList<Deck> = mutableListOf()
    val adapter = DeckAdapter(dataset)

    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //RESULT_OK returned value that indicates successful results between activities
        if(it.resultCode == RESULT_OK) {
            val question = it.data?.getStringExtra("QUESTION")
            val answer = it.data?.getStringExtra("ANSWER")
            val position = it.data?.getIntExtra("DECK_POSITION", 0)
            dataset[position!!].addCard(question!!, answer!!)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityMainBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)
        registerForContextMenu(binding.mainRecyclerview)

        binding.mainRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.mainRecyclerview.adapter = adapter

        binding.mainFab.setOnClickListener {
            // menu -
            // Deck shuffle
            // flashcard mode
//            dataset.add(Deck("Deck ${dataset.size}"))
//            adapter.notifyItemInserted(dataset.size-1)
        }

        adapter.onItemClick = {
            val deckObJ = Gson()
            val intent = Intent(this@MainActivity, CardActivity::class.java)
            intent.putExtra("DECK_CLICKED",deckObJ.toJson(it))
            startActivity(intent)
        }

        dataset.add(Deck("Default deck"))
        dataset[dataset.size-1].addCard("Two important desing issues for cache memory are __.", "Size and replacement policy")
        dataset[dataset.size-1].addCard("T/F The producer-consumer problem using a bounded buffer cannot be solved using shared memory", "False")
        dataset[dataset.size-1].addCard("The _____ model maps each user-level thread to one kernel thread", "One-to-One")
        dataset[dataset.size-1].addCard("A ___ provides an API for creating and managing threads", "Thread Library")
        dataset[dataset.size-1].addCard("Deferred cancellation is preferred over asynchronous cancellation", "True")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            // add card
            101 -> {
                val intent = Intent(this@MainActivity, AddCardActivity::class.java)
                intent.putExtra("DECK_POSITION", item.groupId)
                getContent.launch(intent)
                true
            }
            // add deck
            102 -> {
                dataset.add(Deck("Deck ${dataset.size}"))
                adapter.notifyItemInserted(dataset.size-1)
                return true
            }
            103 -> {
                dataset[item.groupId].setDeckName("Changed the deck name")
                adapter.notifyDataSetChanged()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
}