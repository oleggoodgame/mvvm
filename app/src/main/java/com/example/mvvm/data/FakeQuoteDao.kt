package com.example.mvvm.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//LiveData — це об'єкт в Android, який надає дані, що можуть змінюватися, і дозволяє спостерігати за цими даними. Це частина архітектурних компонентів Android, що спрощує керування даними та їх відображенням у UI. Основні характеристики LiveData:
//
//Життєвий цикл: LiveData прив'язана до життєвого циклу компонентів (наприклад, активностей і фрагментів). Це означає, що LiveData автоматично припиняє оновлення даних для неактивних компонентів і відновлює їх, коли компонент повертається в активний стан.
//
//Обновлення даних: Якщо дані в LiveData змінюються, всі активні спостерігачі отримують оновлення автоматично. Це дозволяє спростити синхронізацію UI з даними.
//
//Неможливість модифікації зовні: LiveData надає лише можливість читання даних для спостерігачів. Це забезпечує безпечний спосіб доступу до даних, що дозволяє уникнути ненавмисного їх зміни.
//
//Основні методи LiveData
//observe(lifecycleOwner: LifecycleOwner, observer: Observer<T>): Додає спостерігача, який буде отримувати оновлення, коли дані змінюються. lifecycleOwner контролює, коли спостерігач буде активним або неактивним.
//
//getValue(): Отримує поточне значення даних. Для LiveData це може бути використано, але зазвичай дані змінюються через інші методи (наприклад, через MutableLiveData).
//
//setValue(value: T): Встановлює нове значення для MutableLiveData. Використовується в разі модифікації даних.

class FakeQuoteDao {
    //Чому не можна скоротити до одного поля?
    //Різні обов'язки: quoteList використовується для управління даними в пам'яті і модифікації даних, а quotes для спостереження за цими даними. Це дозволяє розділити обов'язки і спростити доступ до даних у різних частинах програми.
    //
    //Операції з даними: Якщо скоротити до одного поля MutableLiveData, кожного разу, коли ти модифікуєш дані (додаєш нову цитату), потрібно буде оновлювати значення LiveData. Це може бути менш ефективно і менш зрозуміло, ніж використання проміжного локального списку.
    //
    //Розширення функціональності: Локальний список quoteList дозволяє легко модифікувати дані без змінювати LiveData, яке забезпечує тільки читання даних для UI.
    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
        Log.d("FakeDataBase", "Fake QuetoDao Base create $quotes")
    }

    fun addQuote(quote: Quote) {
        quoteList.add(quote)
        quotes.value = quoteList
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}