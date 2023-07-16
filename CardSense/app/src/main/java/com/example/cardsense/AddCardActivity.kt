package com.example.cardsense

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.databinding.ActivityAddcardBinding


class AddCardActivity : AppCompatActivity() {

    //ActivityAddcardBinding refers to the activity_addcard xml file
    private lateinit var binding: ActivityAddcardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //This line initializes the binding object which you'll use to access Views
        binding = ActivityAddcardBinding.inflate(layoutInflater)
        //this specifies the root of the hierarchy of views in your app, binding.root.
        setContentView(binding.root)

        binding.addcardButton.setOnClickListener {

            val deck_position = intent.getIntExtra("DECK_POSITION", 0)
            val intent = Intent(this@AddCardActivity,MainActivity::class.java)
            intent.putExtra("QUESTION",binding.frontId.text.toString())
            intent.putExtra("ANSWER", binding.backId.text.toString())
            intent.putExtra("DECK_POSITION",deck_position)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}