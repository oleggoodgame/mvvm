package com.example.mvvm.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.mvvm.R
import com.example.mvvm.databinding.FragmentList1Binding

class FragmentList1 : Fragment() {
    private lateinit var binding: FragmentList1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentList1Binding.inflate(inflater, container, false)
        val viewpager = activity?.findViewById<ViewPager2>(R.id.viewpager2)
        binding.textNext.setOnClickListener(){
            viewpager?.currentItem = 1
        }
        return binding.root
    }
}