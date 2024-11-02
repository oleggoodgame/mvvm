package com.example.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.example.mvvm.databinding.FragmentBlank1Binding
import com.example.mvvm.databinding.FragmentBlank2Binding

class BlankFragment2 : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var binding: FragmentBlank2Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlank2Binding.inflate(inflater)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.sendToFragment2.setOnClickListener {
            dataModel.message2.value = "Fragment2"
        }
        binding.sendToOther2.setOnClickListener {
            dataModel.message.value = "Activity2"
        }
        dataModel.message1.observe(activity as LifecycleOwner,{message->
            binding.message2.text = message
        })
    }

}