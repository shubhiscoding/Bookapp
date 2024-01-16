package com.example.bookapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.bookapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var imageView: ImageView
    private val list: ArrayList<BooksModel> = ArrayList()
    private val adapter = BooksAdapter(list, this)
    private lateinit var extendedFloatingActionButton: ExtendedFloatingActionButton
    private lateinit var button: Button

    private val ADD_BOOK_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            mRecyclerViewHome.adapter = adapter
            list.add(BooksModel(R.drawable.book_1, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_2, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_3, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_4, "Book_Title", "Book_description", "Owner's_contact"))
            list.add(BooksModel(R.drawable.book_5, "Book_Title", "Book_description", "Owner's_contact"))
        }
        extendedFloatingActionButton = findViewById(R.id.search)
        extendedFloatingActionButton.setOnClickListener {
            val shareABookIntent = Intent(this, ShareABook::class.java)
            startActivityForResult(shareABookIntent, ADD_BOOK_REQUEST_CODE)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            // Retrieve data from ShareABook activity
            val title = data?.getStringExtra("title")
            val desc = data?.getStringExtra("desc")

            // Add a new book to the list
            list.add(BooksModel(R.drawable.download, title.toString(), desc.toString(), "Owner's_contact"))

            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()
        }
    }
}
