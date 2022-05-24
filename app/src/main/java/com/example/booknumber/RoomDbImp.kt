package com.example.booknumber

import com.example.booknumber.roomdb.BookNumberDAO
import com.example.booknumber.roomdb.BookNumberEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RoomDbImp(private val bookNumberDAO: BookNumberDAO) {


    suspend fun insert(bookNumberEntity: BookNumberEntity){
        withContext(Dispatchers.Default){
            bookNumberDAO.insert(bookNumberEntity)
        }
    }

    fun getByNumber(name: String) : Flow<BookNumberEntity> =bookNumberDAO.getByName(name)

    fun getName(name: String): Flow<BookNumberEntity> =bookNumberDAO.getByName(name)


}