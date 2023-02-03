package com.example.retrofitwithmvvm.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitwithmvvm.models.QuoteModel

@Database(entities = [QuoteModel::class], version = 1)
abstract class QuoteDataBase:RoomDatabase() {
    abstract fun quotDao():QuotDao
//    companion object {
//        private var INSTANCE: QuoteDataBase? = null
//        fun getDataBase(context: Context): QuoteDataBase {
//            if (INSTANCE == null) {
//                synchronized(this) {
//                    INSTANCE =
//                        Room.databaseBuilder(context, QuoteDataBase::class.java, "quote_database")
//                            .build()
//                }
//
//            }
//            return INSTANCE!!
//        }
//    }
}