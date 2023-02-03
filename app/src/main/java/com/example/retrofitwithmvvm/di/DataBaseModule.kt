package com.example.retrofitwithmvvm.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.retrofitwithmvvm.db.QuoteDataBase

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun provideDataRoomDataBAse(context:Context):QuoteDataBase{
        return Room.databaseBuilder(context , QuoteDataBase::class.java,"new_quote_database" ).build()
    }
}