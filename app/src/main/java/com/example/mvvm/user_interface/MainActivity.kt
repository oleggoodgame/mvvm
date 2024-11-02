package com.example.mvvm.user_interface

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.Quote
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.utilities.InjectorUtils
// Щодо вашого питання про зберігання списку без ListView або RecyclerView, ось як це працює:
//
//Зберігання даних:
//
//У вашому випадку, ви зберігаєте список у FakeQuoteDao у вигляді MutableLiveData<List<Quote>>. Це дозволяє вам відстежувати і оновлювати список цитат, коли вони змінюються.
//Оновлення даних:
//
//Коли ви додаєте нову цитату, ви використовуєте метод addQuote у FakeQuoteDao, який додає нову цитату до quoteList і оновлює quotes.value. Це оновлення автоматично сповіщає всі спостерігачі (Observers), які слідкують за LiveData.
//Оновлення інтерфейсу користувача:
//
//Навіть якщо ви не використовуєте ListView або RecyclerView, ви можете оновлювати інтерфейс користувача, використовуючи TextView або інші елементи. У вашому випадку ви використовуєте TextView для відображення списку цитат як простого тексту.
class MainActivity : AppCompatActivity() {

    // View Binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ініціалізуємо Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("QuotesActivity", "Start")
        initializeUi()
    }

    private fun initializeUi() {
        // 1. Отримання фабрики для ViewModel
        val factory = InjectorUtils.provideQuotesViewModelFactory()

        // 2. Отримання екземпляру ViewModel через ViewModelProvider
        val viewModel = ViewModelProvider(this, factory).get(QuotesViewModel::class.java)

        // 3. Спостереження за змінами у списку цитат
        // this:
        //
        //У цьому контексті this вказує на активність (або фрагмент), в якій виконується код. Це необхідно для того, щоб LiveData міг зв'язати себе з життєвим циклом цієї активності або фрагмента. LiveData спостерігає за змінами даних і автоматично оновлює UI, коли дані змінюються. this допомагає LiveData знати, коли його спостерігачі (об'єкти Observer) мають бути активовані або деактивовані відповідно до життєвого циклу активності чи фрагмента.
        //Observer { quotes -> ... }:
        //
        //Observer — це інтерфейс, який визначає, що робити, коли дані в LiveData змінюються. У цьому випадку, він отримує список quotes і виконує блок коду всередині { ... }, коли цей список змінюється.
        //Observer спостерігає за LiveData, і коли LiveData оновлює своє значення, Observer спрацьовує і запускає вказаний блок коду.
        //Отримання quotes:
        //
        //Метод getQuotes() повертає LiveData<List<Quote>>. Це означає, що LiveData містить список цитат (List<Quote>).
        //Коли ви викликаєте observe, ви вказуєте Observer, який буде отримувати нові дані кожного разу, коли значення LiveData змінюється. У цьому випадку, quotes представляє список цитат, який оновлюється в UI.
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            // Застосовуємо binding для оновлення тексту
            binding.textViewQuotes.text = stringBuilder.toString()
        })

        // 4. Налаштування обробника подій для кнопки
        binding.buttonAddQuote.setOnClickListener {
            val quote = Quote(
                binding.editTextQuote.text.toString(),
                binding.editTextAuthor.text.toString()
            )
            viewModel.addQuote(quote)
            // Очищення полів вводу
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
            Log.d("QuotesActivity", "Quote added: $quote")

        }

    }

}
