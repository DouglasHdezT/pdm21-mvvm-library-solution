package com.deushdezt.library.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
data class Book (
    @PrimaryKey
    var ISBN: String,
    var name: String,
    var author: String,
    var editorial: String,
    var date: String
)