package com.example.cardsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.databinding.ActivityDeckBinding
import com.example.cardsense.databinding.ActivityMainBinding

class DeckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeckBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityDeckBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)
    }
}