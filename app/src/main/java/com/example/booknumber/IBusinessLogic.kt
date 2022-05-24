package com.example.booknumber

import com.example.booknumber.roomdb.BookNumberDAO
import com.example.booknumber.roomdb.BookNumberEntity

interface IBusinessLogic {
     fun insertData(bookNumberDAO: BookNumberDAO)
     fun searchNumber(bookNumberDAO: BookNumberDAO)
     fun showMessage(message:String)

}