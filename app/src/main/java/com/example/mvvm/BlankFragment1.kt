package com.example.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.mvvm.databinding.FragmentBlank1Binding
// activityViewModels() — це делегат для створення та доступу до ViewModel, який спільний між Fragment та Activity, у якій цей Fragment знаходиться.
//Він використовується, коли ти хочеш, щоб кілька Fragment-ів (або Activity) мали доступ до одного і того ж ViewModel через їхню спільну Activity. Це корисно для обміну даними між фрагментами або для того, щоб зберігати дані протягом життєвого циклу Activity, навіть якщо фрагменти змінюються.
class BlankFragment1 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank1Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.sendToFragment1.setOnClickListener {
            dataModel.message1.value = "Fragment1"
        }
        binding.sendToOther1.setOnClickListener {
            dataModel.message.value = "Activity1"
        }
        dataModel.message2.observe(activity as LifecycleOwner,{ message->
            binding.message1.text = message
        })
    }

}