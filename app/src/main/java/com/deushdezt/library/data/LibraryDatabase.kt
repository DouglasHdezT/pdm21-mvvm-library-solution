package com.deushdezt.library.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.deushdezt.library.data.dao.BookDao
import com.deushdezt.library.data.entity.Book

@Database(version = 1, entities = [Book::class])
abstract class LibraryDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: LibraryDatabase? = null

        fun getDatabase(context: Context) = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context,
                LibraryDatabase::class.java,
                "library_db"
            ).build()

            INSTANCE = instance
            instance
        }
    }

}