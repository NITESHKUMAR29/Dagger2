package com.example.retrofitwithmvvm.api

import com.example.retrofitwithmvvm.models.ApiResponseQuoteModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteApi {
    
    @GET("/quotes")
   fun getQuote(@Query("page") page:Int):Call<ApiResponseQuoteModel>


    //dusra method
    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int):Response<ApiResponseQuoteModel>
}