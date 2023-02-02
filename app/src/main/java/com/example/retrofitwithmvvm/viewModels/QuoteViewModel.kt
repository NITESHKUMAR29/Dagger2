package com.example.retrofitwithmvvm.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitwithmvvm.models.ApiResponseQuoteModel
import com.example.retrofitwithmvvm.reposetories.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) :ViewModel(){

    private val getQuote=MutableLiveData<ApiResponseQuoteModel>()


    private val error=MutableLiveData<Throwable>()

     fun getQuote(page:Int):LiveData<ApiResponseQuoteModel>{
        quoteRepository.getData(page,getQuote,error)
         return getQuote
    }

    //ye dusra tarika
    suspend fun getQuotes(page:Int):LiveData<ApiResponseQuoteModel>{
        Log.d("nk/thread2",Thread.currentThread().name)
      quoteRepository.getDatas(page)
        return  quoteRepository.getData
    }
}