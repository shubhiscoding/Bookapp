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
    private lateinit var editText: EditText
    private lateinit var buttonUpload: Button
    private lateinit var editTextdays: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareAbookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        editTextTitle = findViewById(R.id.Book_Tittle)
        editTextDesc = findViewById(R.id.BookDesc)
        buttonUpload = findViewById(R.id.upload)
        editText = findViewById(R.id.owner_contact)
        editTextdays = findViewById(R.id.editTextNumber2)
        buttonUpload.setOnClickListener {
            val title = editTextTitle.text.toString()
            val desc = editTextDesc.text.toString()
            val contact = editText.text.toString()
            val days = editTextdays.text.toString().toInt()
            if (title.isNotEmpty() && desc.isNotEmpty() && contact.isNotEmpty() && editTextdays.text.isNotEmpty()) {
                // Send the data back to MainActivity
                val resultIntent = Intent()
                resultIntent.putExtra("title", title)
                resultIntent.putExtra("desc", desc)
                resultIntent.putExtra("contact", contact)
                resultIntent.putExtra("maxDays", days)
                setResult(RESULT_OK, resultIntent)
                finish()
            } else {
                Toast.makeText(this, "Bakchodi maat karr", Toast.LENGTH_LONG).show()
            }
        }
    }
}
