package com.example.mvvm.user_interface

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.QuoteRepository


class QuotesViewModelFactory(private val quoteRepository: QuoteRepository)
    : ViewModelProvider.NewInstanceFactory() {
        // ViewModelProvider.NewInstanceFactory(): Цей клас є реалізацією ViewModelProvider.Factory, яка дозволяє створювати нові екземпляри ViewModel. Він потрібен, коли ваш ViewModel має параметри в конструкторі (в даному випадку QuoteRepository)
    @Suppress("UNCHECKED_CAST") // @Suppress("UNCHECKED_CAST"): Ця анотація використовується для подавлення попереджень компілятора про небезпечне приведення типів (unchecked cast). У нашому випадку, це попередження, оскільки Java не може перевірити безпеку приведення типів під час компіляції.
    override fun <T : ViewModel> create(modelClass: Class<T>): T { // override fun <T : ViewModel> create(modelClass: Class<T>): T: Цей метод створює новий екземпляр ViewModel.

            Log.d("ViewModelFactory", "idk what is that")
        return QuotesViewModel(quoteRepository) as T
    }
//odelClass: Class<T>: Це клас ViewModel, який потрібно створити.
//
//QuotesViewModel(quoteRepository) as T: Створює новий екземпляр QuotesViewModel і приводить його до типу T. Це приведення є небезпечним, тому ми використовуємо @Suppress("UNCHECKED_CAST"), щоб уникнути попереджень компілятора.
    //QuotesViewModelFactory: Створює екземпляри QuotesViewModel, забезпечуючи ін'єкцію залежностей через конструктор.
    }