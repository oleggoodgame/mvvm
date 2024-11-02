package com.example.mvvm.viewmodelfactory

import androidx.lifecycle.ViewModel

class Model(private val model: String) : ViewModel() {
    val items: MutableList<String> = mutableListOf()

    fun addItem(item: String) {
        items.add(item)
    }

    fun all(): Int {
        return items.size
    }
}