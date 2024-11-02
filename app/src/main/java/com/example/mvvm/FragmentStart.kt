package com.example.mvvm

import android.content.Context
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import java.util.logging.Handler

class FragmentStart : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val sharedPref = requireActivity().getSharedPreferences("OnBoarding", Context.MODE_PRIVATE)
            val gets = sharedPref.getBoolean("Finish", false)
            if (gets) {
                findNavController().navigate(R.id.action_fragmentStart_to_mainFragment)
            } else {
                findNavController().navigate(R.id.action_fragmentStart_to_viewPagerFragment1)
            }
        }, 3000)

        return inflater.inflate(R.layout.fragment_start, container, false)
    }

}