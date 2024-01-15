package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bookapp.databinding.ActivityMainBinding
import com.example.bookapp.BooksAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val list: ArrayList<BooksModel> = ArrayList()
    private val adapter = BooksAdapter(list, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.show()
        binding.apply {
            mRecyclerViewHome.adapter = adapter
            list.add(BooksModel(R.drawable.book_1, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_2, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_3, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_4, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_5, "Book_Title", "Book_description", "Owner's_contact"))
        }
    }
}
