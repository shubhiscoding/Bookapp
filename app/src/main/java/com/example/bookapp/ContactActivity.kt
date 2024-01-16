package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.bookapp.databinding.ActivityContactDetailBinding
import com.example.bookapp.databinding.ActivityDetailsBinding

class ContactActivity : AppCompatActivity() {
    val activity =  this
    lateinit var binding: ActivityContactDetailBinding
    private lateinit var textView: TextView
    private lateinit var days: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactdetail = intent.getStringExtra("contact").toString()
        val maxDays = intent.getIntExtra("maxDays", 0)
        textView = findViewById(R.id.contact_detail)
        textView.text = contactdetail
        days = findViewById(R.id.maxdaysdisplay)
        days.text = maxDays.toString()
    }
}