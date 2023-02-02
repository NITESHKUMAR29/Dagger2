package com.example.retrofitwithmvvm.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.retrofitwithmvvm.models.QuoteModel

@Dao
interface QuotDao {

    @Insert
    suspend fun addQuot(quoteModels: List<QuoteModel>)

    @Query("SELECT * from quote")
    fun getQuoteTotal():LiveData<List<QuoteModel>>
}