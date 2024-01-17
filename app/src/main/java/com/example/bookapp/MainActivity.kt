package com.example.bookapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bookapp.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import kotlin.collections.ArrayList

var list: ArrayList<BooksModel> = ArrayList()
var count =-1
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var list2: ArrayList<BooksModel> = ArrayList()
    val adapter = BooksAdapter(list, this)
    private lateinit var extendedFloatingActionButton: ExtendedFloatingActionButton
    private val ADD_BOOK_REQUEST_CODE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            mRecyclerViewHome.adapter = adapter
            if(count<4){
                list.add(BooksModel(R.drawable.book_1, "Rich Dad Poor Dad", "Book_description", "Owner's_contact", 5, false, count+1,0))
                count+=1
                list.add(BooksModel(R.drawable.book_2, "Atomic Habit", getString(R.string.atomic_habit_descript), "Owner's_contact", 5, false, count+1,0))
                count+=1
                list.add(BooksModel(R.drawable.book_3, "Best Self", "book_description", "Owner's_contact", 5, false, count+1,0))
                count+=1
                list.add(BooksModel(R.drawable.book_4, "How To be Fine", "Book_description", "Owner's_contact", 5, false, count+1,0))
                count+=1
                list.add(BooksModel(R.drawable.book_5, "Out of the Box", "Book_description", "Owner's_contact", 5, false, count+1,0))
                count+=1
                }
        }
        extendedFloatingActionButton = findViewById(R.id.addbook)
        extendedFloatingActionButton.setOnClickListener {
            val shareABookIntent = Intent(this, ShareABook::class.java)
            startActivityForResult(shareABookIntent, ADD_BOOK_REQUEST_CODE)
        }
        val intent = intent
        if (intent.getStringExtra("confirm") == "confirm") {
            val isBorrow = intent.getBooleanExtra("isBorrowed", false)
            val index = intent.getIntExtra("index", 0)
            val days = intent.getIntExtra("slctdays", 0)
            list[index].isBorrowed = isBorrow
            list[index].slctday = days
            list2.add(list[index])
        }
    }
    @SuppressLint("NotifyDataSetChanged")
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ADD_BOOK_REQUEST_CODE && resultCode == RESULT_OK) {
            // Retrieve data from ShareABook activity
            val title = data?.getStringExtra("title")
            val desc = data?.getStringExtra("desc")
            val contac = data?.getStringExtra("contact")
            val days = data?.getIntExtra("maxDays", 0)
            val max = days!!.toInt()
            // Add a new book to the list
            list.add(BooksModel(R.drawable.download, title.toString(), desc.toString(), contac.toString(), max, false, count+1, 0))
            count+=1
            // Notify the adapter that the data has changed
            adapter.notifyDataSetChanged()
        } else if (resultCode == RESULT_OK && data?.getStringExtra("confirm").toString() == "confirm") {
            // Handle the result from ContactActivity
            val isBorrow = data!!.getBooleanExtra("isBorrowed", false)
            val index = data.getIntExtra("index", 0)
            list[index].isBorrowed = isBorrow
            adapter.notifyDataSetChanged()
        }
    }

}
