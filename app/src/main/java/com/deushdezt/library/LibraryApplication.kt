package com.deushdezt.library

import android.app.Application
import com.deushdezt.library.data.LibraryDatabase
import com.deushdezt.library.repository.BookRepository

class LibraryApplication: Application() {
    private val database by lazy {
        LibraryDatabase.getDatabase(this)
    }

    val bookRepository by lazy {
        val bookDao = database.bookDao()
        BookRepository(bookDao)
    }
}