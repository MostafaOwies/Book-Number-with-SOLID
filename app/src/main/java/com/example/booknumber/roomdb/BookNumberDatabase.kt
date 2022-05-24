package com.example.booknumber.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [BookNumberEntity::class], version = 2)
abstract class BookNumberDatabase:RoomDatabase(){

    abstract fun bookNumberDao ():BookNumberDAO

    companion object{

        @Volatile
        private var INSTANCE:BookNumberDatabase?=null
        fun getInstance(context:Context):BookNumberDatabase{
            synchronized(this){
                var instance= INSTANCE
                if (instance==null){
                    instance=Room.databaseBuilder(
                        context.applicationContext,
                        BookNumberDatabase::class.java,
                        "bookNumber_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE=instance
                }
                return instance
            }
        }
    }
}