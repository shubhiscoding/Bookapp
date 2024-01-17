package com.example.bookapp

data class BooksModel (
    val image: Int?,
    val title: String,
    val description: String,
    val contact: String,
    val maxBorrow: Int,
    var isBorrowed: Boolean,
    var count:Int,
    var slctday:Int,
)