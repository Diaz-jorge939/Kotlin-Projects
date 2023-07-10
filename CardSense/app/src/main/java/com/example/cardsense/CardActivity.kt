package com.example.cardsense

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cardsense.adapter.CardAdapter
import com.example.cardsense.data.Card
import com.example.cardsense.databinding.ActivityCardBinding


class CardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardBinding

    val dataset = mutableListOf<Card>()
    val adapter = CardAdapter(dataset)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardBinding.inflate(layoutInflater)

        setContentView(binding.root)

        dataset.add(Card("What is an operating system?", "responsible for managing system services such as system calls"))

        binding.flashcardRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.flashcardRecyclerview.adapter = adapter

        adapter.onItemClick = {
            Toast.makeText(this, "${it.getFront()}", Toast.LENGTH_SHORT).show()
        }

    }

}