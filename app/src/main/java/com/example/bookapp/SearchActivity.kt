package com.example.bookapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class SearchActivity : AppCompatActivity() {
    private lateinit var textInputEditText: TextInputEditText
    private lateinit var bookList: ArrayList<BooksModel>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        textInputEditText = findViewById(R.id.searchbook)

        // Receive the list from MainActivity
//        bookList = intent.getParcelableArrayListExtra("bookList") ?: ArrayList()

    }
//
//    // Add a method to search for a book
//    private fun searchForBook(title: String): BooksModel? {
//        for (book in bookList) {
//            if (book.title == title) {
//                return book
//            }
//        }
//        return null
//    }
//
//    // Add a method to handle the search button click
//    // You can call this method from your UI component (e.g., a button click)
//    private fun onSearchButtonClick() {
//        val searchTitle = textInputEditText.text.toString()
//        val foundBook = searchForBook(searchTitle)
//
//        if (foundBook != null) {
//            // Found a matching book, you can use foundBook.title, foundBook.image, foundBook.desc
//            // Do something with the found book details
//        } else {
//            // Book not found, handle this case
//        }
//    }
}
