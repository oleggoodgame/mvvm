package com.example.mvvm.user_interface

import androidx.lifecycle.ViewModel
import com.example.mvvm.data.Quote
import com.example.mvvm.data.QuoteRepository

// QuotesViewModelFactory: Це фабрика для створення екземплярів QuotesViewModel. Вона реалізує ViewModelProvider.Factory, який є потрібним для створення ViewModel, якщо конструктор ViewModel має параметри.
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}