package com.example.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

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


        //This is because you want your key listener to be attached as soon as the layout is created
        // and before the user starts interacting with the activity.
        binding.calculateButton.setOnClickListener { calculateTip() }

        binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)}
    }
    private fun calculateTip(){
        //converts EditText View text attribute to string and stores it in stringInTextField variable
        val stringInTextField = binding.costOfServiceEditText.text.toString()
        //convert text to double
        val cost = stringInTextField.toDoubleOrNull()
        if (cost == null) {
            binding.tipResult.text = ""
            return
        }
        // get the RadioButton that was selected by user i.e R.id.option_twenty_percent
        // get tip percentage of corresponding radiobutton
        val tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = tipPercentage * cost
        val roundUp = binding.roundUpSwitch.isChecked

        if(roundUp) {
            tip = ceil(tip)
        }
        //The system automatically formats currency based on the language and other settings that
        // the user has chosen on their phone. Read more about NumberFormat in the Android developer documentation
        //This gives a number formatter you can use to format numbers as currency.
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }

    //helper function that hides onscreen keyboard if the keyCode == KeyEvent.KEYCODE_ENTER
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}