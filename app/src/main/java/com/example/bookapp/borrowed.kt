package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bookapp.databinding.ActivityBorrowedBinding

class borrowed : AppCompatActivity() {
    private lateinit var binding: ActivityBorrowedBinding
     var list: ArrayList<BooksModel> = ArrayList()
    private val adapter = BooksAdapter(list, this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityBorrowedBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val intent = intent
//        list = intent.getParcelableArrayListExtra("list_borrow")!!
    }
}