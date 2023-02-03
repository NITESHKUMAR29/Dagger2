package com.example.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.retrofitwithmvvm.api.QuoteApi
import com.example.retrofitwithmvvm.api.RetrofitHelper
import com.example.retrofitwithmvvm.application.MainApplication
import com.example.retrofitwithmvvm.databinding.ActivityMainBinding
import com.example.retrofitwithmvvm.db.QuoteDataBase
import com.example.retrofitwithmvvm.models.QuoteModel
import com.example.retrofitwithmvvm.reposetories.QuoteRepository
import com.example.retrofitwithmvvm.viewModels.QuoteViewModel
import com.example.retrofitwithmvvm.viewModels.QuoteViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    lateinit var viewModel: QuoteViewModel

    @Inject
    lateinit var quoteViewModelFactory: QuoteViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        val quoteApi = RetrofitHelper.getInstance().create(QuoteApi::class.java)
//        val dataBase=QuoteDataBase.getDataBase(this)
//        val repository = QuoteRepository(quoteApi,dataBase)
        (application as MainApplication).applicationComponent.inject(this)
        viewModel =
            ViewModelProvider(this, quoteViewModelFactory)[QuoteViewModel::class.java]

    //dusra method
//    lifecycleScope.launch{
//
//        viewModel.getQuotes(1).observe(this@MainActivity){
//            Log.d("nk/thread1",Thread.currentThread().name)
//            binding.textView.text=it.results.toString()
//
//        }
//    }
        val randomNumber=(Math.random()*10).toInt()
        viewModel.getQuote(randomNumber).observe(this@MainActivity) {
            Log.d("nk/thread1", Thread.currentThread().name)
            binding.textView.text = it.results.toString()


        }
    }
}