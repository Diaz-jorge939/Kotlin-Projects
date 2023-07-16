package com.example.cardsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.Model.Card
import com.example.cardsense.Model.Deck
import com.example.cardsense.databinding.ActivityStartBinding
import com.google.gson.Gson

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val card = intent.getStringExtra("CARD_CLICKED")
//        val card = Gson().fromJson(cardReceived, Card::class.java)

        binding.answer.text = card
        binding.nextButton.setOnClickListener{
            finish()
        }
        binding.finishButton.setOnClickListener{
            finish()
        }
    }
}