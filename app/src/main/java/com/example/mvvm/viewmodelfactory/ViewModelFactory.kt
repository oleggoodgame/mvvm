package com.example.mvvm.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
class ViewModelFactory (private val model: String) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    //Ця анотація використовується для придушення попередження компілятора щодо неперевіреного приведення типу (unchecked cast).
    // У рядку return Model(model) as T, компілятор не може перевірити на етапі компіляції, чи дійсно Model(model) є типом T,
    // тому виникає попередження. Використання анотації @Suppress("UNCHECKED_CAST") дозволяє приховати це попередження, бо ми знаємо, що це приведення безпечне в даному контексті.
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //override fun <T : ViewModel> create
        //Це перевизначений метод з інтерфейсу ViewModelProvider.Factory,
        // який відповідає за створення екземпляра ViewModel.
        // Важливо, що цей метод параметризований типом T, де T має бути підкласом ViewModel (тобто T : ViewModel).


        if (modelClass.isAssignableFrom(Model::class.java))
        //Цей параметр передає клас ViewModel, який потрібно створити. В Android цей
        //клас використовується для того, щоб вирішити, який тип ViewModel має бути створений, і він передається в фабрику, коли ви викликаєте ViewModelProvider.
        {
            //Це перевірка, чи переданий клас modelClass є класом Model або його підкласом.
            // Метод isAssignableFrom використовується для перевірки, чи можна об'єкт одного типу привести до іншого типу. Якщо це так, то фабрика знає, що може створити екземпляр цього класу.
            //Тут створюється екземпляр класу Model з переданим параметром model (це той параметр, який ви передали в конструктор фабрики). Після цього цей екземпляр приводиться до типу T.
            // Хоча компілятор не може бути впевнений, що приведення буде безпечним, ми використовуємо анотацію @Suppress("UNCHECKED_CAST"), оскільки знаємо, що клас буде відповідати очікуваному типу.
            return Model(model) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}