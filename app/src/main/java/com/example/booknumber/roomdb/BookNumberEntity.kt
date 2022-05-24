package com.example.booknumber.roomdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookNumber-table")
data class BookNumberEntity (

    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    @ColumnInfo(name = "name ID")
    val name:String="",
    @ColumnInfo(name="number ID")
    val number:String=""
    )