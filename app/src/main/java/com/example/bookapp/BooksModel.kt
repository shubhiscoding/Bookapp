package com.example.bookapp

import android.os.Parcel
import android.os.Parcelable

data class BooksModel (
    val image: Int?,
    val title: String,
    val description: String,
    val contact: String,
)