package com.example.mvvm.utilities

import com.example.mvvm.data.FakeDatabase
import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.user_interface.QuotesViewModelFactory
// utilities — Містить утилітарні класи або фабрики:
//
//InjectorUtils — для надання ін'єкцій залежностей
//Інші допоміжні класи, якщо вони потрібні

// object означає оголошення об'єкта-синглтона (singleton). Це означає, що клас створює тільки один екземпляр об'єкта і цей екземпляр доступний глобально. Використання object забезпечує доступ до методів і властивостей без необхідності створювати нові екземпляри класу кожен раз.
object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        QuoteRepository.get()
        //FakeDatabase.getInstance() — викликається метод для отримання єдиного екземпляра бази даних (синглтон). У контексті FakeDatabase це забезпечує, що буде тільки одна база даних під час виконання програми.
        //
        //quoteDao — це об'єкт для доступу до даних (DAO - Data Access Object), який використовується для взаємодії з базою даних. Він містить методи для роботи з таблицею цитат.
        //
        //QuoteRepository.getInstance(...) — це статичний метод, який створює або повертає вже створений екземпляр класу QuoteRepository. Репозиторій збирає дані з різних джерел, таких як база даних, та надає їх ViewModel.
        QuoteRepository.get()
        return QuotesViewModelFactory(quoteRepository)
    }
}
