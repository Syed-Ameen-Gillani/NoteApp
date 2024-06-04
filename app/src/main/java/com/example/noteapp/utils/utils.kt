package com.example.noteapp.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(time:Long):String{
    val date = Date(time)
    val format = SimpleDateFormat("EEE, hh:mm aaa", Locale.getDefault())
    return format.format(date)
}