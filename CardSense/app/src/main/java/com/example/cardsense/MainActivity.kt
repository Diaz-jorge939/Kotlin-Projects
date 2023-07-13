package com.example.cardsense


import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsense.adapter.DeckAdapter
import com.example.cardsense.Model.Deck
import com.example.cardsense.Model.Card
import com.example.cardsense.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(){
    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods in MainActivity class.
    private lateinit var binding: ActivityMainBinding

    val TAG = "MainActivity"
    var count = 0
    val dataset = mutableListOf<Deck>()
    val adapter = DeckAdapter(dataset)
    val getContent = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        //RESULT_OK returned value that indicates successful results between activities
        if(it.resultCode == RESULT_OK) {
            val question = it.data?.getStringExtra("QUESTION")
            val answer = it.data?.getStringExtra("ANSWER")
            println("question: $question answer: $answer")
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

            dataset.add(Deck("Deck $count++"))
            adapter.notifyItemInserted(dataset.size-1)
        }

        adapter.onItemClick = {
//            val intent = Intent(this@MainActivity, AddCardActivity::class.java)

        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            101 -> {
                val intent = Intent(this@MainActivity, AddCardActivity::class.java)
                intent.putExtra("QUESTION", "")
                intent.putExtra("ANSWER", "")
                getContent.launch(intent)
                true
            }
            102 -> {
                dataset.add(Deck("Flashcard $count"))
                dataset[count].addCard("Question $count", "Answer $count")
                count++
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }


}