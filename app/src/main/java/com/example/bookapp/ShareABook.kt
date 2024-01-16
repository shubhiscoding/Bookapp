package com.example.bookapp

import android.content.Intent
import android.health.connect.datatypes.units.Length
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.bookapp.databinding.ActivityShareAbookBinding
import com.google.android.material.textfield.TextInputEditText

class ShareABook : AppCompatActivity() {
    private lateinit var binding: ActivityShareAbookBinding
    private lateinit var editTextTitle: TextInputEditText
    private lateinit var editTextDesc: TextInputEditText
    private lateinit var buttonUpload: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareAbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextTitle = findViewById(R.id.Book_Tittle)
        editTextDesc = findViewById(R.id.BookDesc)
        buttonUpload = findViewById(R.id.upload)

        buttonUpload.setOnClickListener {
            val title = editTextTitle.text.toString()
            val desc = editTextDesc.text.toString()

            if (title.isNotEmpty() && desc.isNotEmpty()) {
                // Send the data back to MainActivity
                val resultIntent = Intent()
                resultIntent.putExtra("title", title)
                resultIntent.putExtra("desc", desc)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Fill all the fields", Toast.LENGTH_LONG).show()
            }
        }
    }
}
