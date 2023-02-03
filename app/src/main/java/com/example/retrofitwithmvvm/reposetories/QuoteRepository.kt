package com.example.retrofitwithmvvm.reposetories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitwithmvvm.api.QuoteApi
import com.example.retrofitwithmvvm.db.QuoteDataBase
import com.example.retrofitwithmvvm.models.ApiResponseQuoteModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteApi: QuoteApi,private val dataBase: QuoteDataBase) {

    fun getData(
        page: Int,
        data: MutableLiveData<ApiResponseQuoteModel>,
        error: MutableLiveData<Throwable>
    ) {
        quoteApi.getQuote(page).enqueue(object : Callback<ApiResponseQuoteModel> {
            override fun onResponse(
                call: Call<ApiResponseQuoteModel>,
                response: Response<ApiResponseQuoteModel>
            ) {
                if (response.body() != null) {
                    data.value = response.body()
                    CoroutineScope(Dispatchers.IO).launch {
                        dataBase.quotDao().addQuot(response.body()!!.results)
                    }
                } else {
                    error.value = null
                }
            }

            override fun onFailure(call: Call<ApiResponseQuoteModel>, t: Throwable) {
                with(error) {
                    value = t
                }
            }

        })

    }


    //dusra method
    private val data=MutableLiveData<ApiResponseQuoteModel>()

        val getData:LiveData<ApiResponseQuoteModel>
        get() = data
    suspend fun getDatas(
        page: Int,

    ) {

       val result=quoteApi.getQuotes(page)
        data.postValue(result.body())
    }

}