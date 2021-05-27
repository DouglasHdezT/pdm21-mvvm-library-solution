package com.deushdezt.library.repository

import com.deushdezt.library.data.dao.BookDao
import com.deushdezt.library.data.entity.Book

class BookRepository(private val bookDao: BookDao) {
    suspend fun insertOrReplace(book: Book) = bookDao.insertOrReplace(book)
    fun findAll() = bookDao.findAll()
}