package com.example.retrofitwithmvvm.di

import androidx.room.Database
import com.example.retrofitwithmvvm.api.QuoteApi
import com.example.retrofitwithmvvm.constant.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class ApplicationModule {


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.Base_Url)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideQuoteApi(retrofit: Retrofit):QuoteApi{
        return retrofit.create(QuoteApi::class.java)
    }


}