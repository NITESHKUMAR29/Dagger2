package com.example.retrofitwithmvvm.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.reposetories.QuoteRepository
import javax.inject.Inject

class QuoteViewModelFactory @Inject constructor(private val quoteRepository: QuoteRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuoteViewModel(quoteRepository) as T
    }
}