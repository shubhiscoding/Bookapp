package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapp.databinding.ActivityContactDetailBinding
import com.example.bookapp.databinding.ActivityDetailsBinding

class ContactActivity : AppCompatActivity() {
    val activity =  this
    lateinit var binding: ActivityContactDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contactdetail = intent.getStringExtra("contact").toString()

        binding.apply {
            contactDetail.text = contactdetail
        }
    }
}