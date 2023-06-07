package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Android automatically assigns ID numbers to the resources in your app.
        // For example, the Roll button has a resource ID, and the string for the button text also has a resource ID.
        // Resource IDs are of the form R.<type>.<name>; for example, R.string.roll.
        // For View IDs, the <type> is id, for example, R.id.button.

        // The code saves the reference to the Button object in a variable called rollButton, not the Button object itself.
        val rollButton: Button = findViewById(R.id.button)

        //declaring Lambda
        rollButton.setOnClickListener{
            rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Find the Image View in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)

        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = dice.roll().toString()

        when(diceRoll) {
            // when diceRoll is 1..6, then display dice image
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }
}
class Dice(private val numSides: Int) {
    fun roll(): Int{
        return (1..numSides).random()
    }
}