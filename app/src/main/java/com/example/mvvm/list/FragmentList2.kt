package com.example.mvvm.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentList2Binding

class FragmentList2 : Fragment() {
    private lateinit var binding: FragmentList2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentList2Binding.inflate(inflater, container, false)
        val viewpager = activity?.findViewById<ViewPager2>(R.id.viewpager2)
        binding.finish.setOnClickListener(){
            findNavController().navigate(R.id.action_viewPagerFragment1_to_mainFragment)
            val sharedPref = requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("Finish", true)
            editor.apply()
        }
        return binding.root
    }

}