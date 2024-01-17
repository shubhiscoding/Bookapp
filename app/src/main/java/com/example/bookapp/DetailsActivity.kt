package com.example.bookapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.bookapp.databinding.ActivityDetailsBinding
import com.example.bookapp.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    private val activity = this
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bookTitle = intent.getStringExtra("book_title").toString()
        val bookDesc = intent.getStringExtra("book_desc").toString()
        val contact = intent.getStringExtra("contact").toString()
        val bookImage = intent.getIntExtra("book_image", 0)
        val days = intent.getIntExtra("maxDays", 0)
        val slctdays = intent.getIntExtra("slctday", 0)
        val index =  intent.getIntExtra("index", 0);
        val isBorrowed = intent.getBooleanExtra("isBorrowed", false)
        binding.apply {
            mBookTitle.text = bookTitle
            mBookDesc.text = bookDesc
            mBookImage.setImageResource(bookImage)
            if (isBorrowed) {
                val txt = "available in $slctdays days"
                mAvailable.text = txt
                mReadBookBtn.setOnClickListener {
                    Toast.makeText(activity, "$txt", Toast.LENGTH_LONG).show()
                }
            } else {
                mReadBookBtn.setOnClickListener {
                    val intent = Intent(activity, ContactActivity::class.java)
                    intent.putExtra("contact", contact)
                    intent.putExtra("maxDays", days)
                    intent.putExtra("book_image", bookImage)
                    intent.putExtra("index", index)
                    startActivityForResult(intent, 2)
                }
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && requestCode == 2) {
            val isBorrow = data?.getBooleanExtra("isBorrowed", false)
            val index = data?.getIntExtra("index", 0)
            val slctday = data?.getIntExtra("slct_day", 0)
            if(isBorrow!=null && index != null) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("isBorrowed", isBorrow)
                intent.putExtra("index", index)
                intent.putExtra("slctdays", slctday)
                intent.putExtra("confirm", "confirm")
                startActivity(intent)
            }
        }
    }

}