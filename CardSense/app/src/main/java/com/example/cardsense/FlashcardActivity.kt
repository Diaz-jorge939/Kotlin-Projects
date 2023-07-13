package com.example.cardsense

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cardsense.data.Flashcard
import com.example.cardsense.databinding.ActivityFlashcardBinding

class FlashcardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFlashcardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

    }
}