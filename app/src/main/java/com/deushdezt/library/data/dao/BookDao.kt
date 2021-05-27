package com.deushdezt.library.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.deushdezt.library.data.entity.Book

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrReplace(book: Book)

    @Query("SELECT * FROM book_table")
    fun findAll(): LiveData<List<Book>>
}