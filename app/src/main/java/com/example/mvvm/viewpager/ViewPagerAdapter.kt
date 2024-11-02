package com.example.mvvm.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
// FragmentStateAdapter є базовим класом для адаптерів, які працюють з ViewPager2 і управляють фрагментами. Він є частиною бібліотеки androidx.viewpager2.
class ViewPagerAdapter(list: ArrayList<Fragment>, fm:FragmentManager, lf: Lifecycle):FragmentStateAdapter(fm, lf) {
    val fragmentlist: ArrayList<Fragment> = list
    override fun getItemCount(): Int {
        return fragmentlist.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentlist[position]
    }

}

//Як працює адаптер:
//Ініціалізація:
//
//Коли ви створюєте об'єкт ViewPagerAdapter, ви передаєте список фрагментів, FragmentManager і Lifecycle.
//Адаптер зберігає список фрагментів у полі fragmentlist.
//Кількість елементів:
//
//Метод getItemCount() повертає кількість фрагментів у списку, що визначає кількість сторінок у ViewPager2.
//Створення фрагментів:
//
//Метод createFragment(position: Int) повертає фрагмент для конкретної позиції. ViewPager2 викликає цей метод для створення фрагментів, які потрібно відобразити.