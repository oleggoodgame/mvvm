package com.example.mvvm.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvvm.databinding.FragmentViewPager1Binding
import com.example.mvvm.list.FragmentList1
import com.example.mvvm.list.FragmentList2

class ViewPagerFragment1 : Fragment() {

    // Пряме використання binding без _binding
    private lateinit var binding: FragmentViewPager1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Ініціалізація binding
        binding = FragmentViewPager1Binding.inflate(inflater, container, false)
        val fragmentList = arrayListOf(
            FragmentList1(),
            FragmentList2()
        )
        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)
//equireActivity(): Цей метод викликається з фрагмента, щоб отримати активність, до якої він приєднаний. Якщо фрагмент не приєднаний до активності, метод викликає виняток (exception).
//
//supportFragmentManager: Це менеджер, який керує фрагментами у вашій активності. Він відповідає за:
//
//Додавання, видалення або заміну фрагментів.
//Відображення фрагментів на екрані.
//Організацію транзакцій між фрагментами.

        binding.viewpager2.adapter = adapter // lifecycle автоматично доступний у фрагментах та активностях і відноситься до класу Lifecycle, який відстежує стан життєвого циклу вашого компонента (активності чи фрагмента). Lifecycle дозволяє адаптеру або іншим компонентам стежити за змінами станів, наприклад, коли фрагмент чи активність створюється, зупиняється або знищується.
        return binding.root
    }
}
