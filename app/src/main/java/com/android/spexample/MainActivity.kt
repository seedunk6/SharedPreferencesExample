package com.android.spexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.spexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        checkDataSaved()

    }

    private fun init() {
        binding.btnNext.setOnClickListener {
            validateFields()
        }
    }

    private fun checkDataSaved() {
        if(SharedPreferences.getName().isNotEmpty() && SharedPreferences.getAge() != 0) {
            goToSavedData()
        }
    }

    private fun validateFields() {
        if(binding.etName.text.toString().isNotEmpty() && binding.etAge.text.toString().isNotEmpty()) {
            SharedPreferences.setName(binding.etName.text.toString())
            SharedPreferences.setAge(binding.etAge.text.toString().toInt())
            goToSavedData()
        }
    }

    private fun goToSavedData() {
        finish()
        startActivity(Intent(this, SavedDataActivity::class.java))
    }

}