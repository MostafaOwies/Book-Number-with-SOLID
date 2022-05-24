package com.example.booknumber

import android.app.Application
import com.example.booknumber.roomdb.BookNumberDatabase

class BookNumberApp:Application() {

    val db by lazy {
        BookNumberDatabase.getInstance(this)
    }
}