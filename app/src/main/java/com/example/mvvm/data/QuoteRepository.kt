package com.example.mvvm.data

import android.util.Log
import com.example.mvvm.data.FakeDatabase.Companion
// Призначення: Використовується для обробки даних, що надходять з FakeQuoteDao (DAO), і для управління доступом до цих даних.
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao){

    fun addQuote(quote: Quote) {
        quoteDao.addQuote(quote)
    }

    fun getQuotes() = quoteDao.getQuotes()

    companion object {
        @Volatile private var instance: QuoteRepository? = null

        fun getInstance(quoteDao: FakeQuoteDao) =
            instance ?: synchronized(this) {
                instance ?: QuoteRepository(quoteDao).also { instance = it }
            }

        public fun get(): Unit{
            Log.d("QuoteRepository", "Fake Data Base create $instance")
        }
    }
}