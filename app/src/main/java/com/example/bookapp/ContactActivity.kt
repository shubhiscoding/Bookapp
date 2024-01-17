package com.example.bookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import com.example.bookapp.databinding.ActivityContactDetailBinding
import com.example.bookapp.databinding.ActivityDetailsBinding

class ContactActivity : AppCompatActivity() {
    val activity =  this
    lateinit var binding: ActivityContactDetailBinding
    private lateinit var textView: TextView
    private lateinit var days: TextView
    private lateinit var button: Button
    private lateinit var numberPicker: NumberPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactdetail = intent.getStringExtra("contact").toString()
        val maxDays = intent.getIntExtra("maxDays", 0)
        val index = intent.getIntExtra("index", 0)

        textView = findViewById(R.id.contact_detail)
        textView.text = contactdetail
        numberPicker = findViewById(R.id.numberPicker)
        numberPicker.minValue = 1 // Set the minimum value
        numberPicker.maxValue = maxDays // Set the maximum value
        numberPicker.wrapSelectorWheel = false

        button = findViewById(R.id.confrimbtn)
        button.setOnClickListener{
            val selectedDays = numberPicker.value
            val intent = Intent()
            intent.putExtra("isBorrowed", true)
            intent.putExtra("index", index)
            intent.putExtra("slct_day", selectedDays)
            intent.putExtra("confirm", "confirm")
            setResult(RESULT_OK, intent)
            finish() // Finish ContactActivity and return to the previous activity (DetailsActivity)
        }

    }
}