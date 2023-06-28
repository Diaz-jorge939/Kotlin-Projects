package com.example.cardsense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.databinding.ActivityAddcardBinding
import com.example.cardsense.databinding.ActivityDeckBinding

class AddCardActivity : AppCompatActivity() {

    //ActivityAddcardBinding refers to the activity_addcard xml file
    private lateinit var binding: ActivityAddcardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityAddcardBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)
    }
}