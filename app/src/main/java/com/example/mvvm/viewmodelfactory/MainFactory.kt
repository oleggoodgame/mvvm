package com.example.mvvm.viewmodelfactory

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory

class RecyclerFragment : Fragment() {

    private lateinit var viewModel: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Передаємо параметр у фабрику
        val model = "SomeModel"
        val factory = ViewModelFactory(model)

        // Отримуємо ViewModel за допомогою фабрики
        viewModel = ViewModelProvider(this, factory).get(Model::class.java)
    }

}
