package com.example.booknumber.roomdb

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BookNumberDAO  {
    @Insert
    suspend fun insert(bookNumberEntity: BookNumberEntity)
    @Query("SELECT*FROM `bookNumber-table` where `name ID`=:name")
     fun getByName(name :String):Flow<BookNumberEntity>
     @Query("SELECT*FROM `bookNumber-table`where `name ID`=:name")
     fun  getName(name: String):Flow<BookNumberEntity>
}