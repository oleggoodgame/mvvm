package com.example.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvm.databinding.ActivityConstraitBinding

class ActivityConstraint : AppCompatActivity() {

    private lateinit var binding: ActivityConstraitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Використовуємо ViewBinding для зручного доступу до елементів макету
        binding = ActivityConstraitBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Тут можна додати додаткову логіку для навігації або інші операції
    }
}
