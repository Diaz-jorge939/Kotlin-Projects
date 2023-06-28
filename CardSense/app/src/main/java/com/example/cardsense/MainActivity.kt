package com.example.cardsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //This line declares a top-level variable in the class for the binding object.
    // It's defined at this level because it will be used across multiple methods in MainActivity class.
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityMainBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)
    }
}