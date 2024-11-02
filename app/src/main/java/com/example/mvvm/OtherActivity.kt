package com.example.mvvm

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mvvm.databinding.ActivityOtherBinding

class OtherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtherBinding
    //це делегат для створення та доступу до ViewModel, який прив'язаний до конкретного Fragment
    // Він створює та надає ViewModel, який існує тільки в контексті конкретного Fragment. Це означає, що кожен Fragment може мати свій власний екземпляр ViewModel, незалежний від інших фрагментів.
    private val dataModel: DataModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        changeFtoF(R.id.frame_fragment_1, BlankFragment1())
        changeFtoF(R.id.frame_fragment_2, BlankFragment2())
        dataModel.message.observe(this@OtherActivity, { message ->
            binding.textViewOther.text = message
        })
    }

    private fun changeFtoF(id: Int, f: Fragment) {
        supportFragmentManager.beginTransaction().replace(id, f).commit()
    }
}
