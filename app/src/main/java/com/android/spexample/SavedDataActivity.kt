package com.android.spexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.spexample.databinding.ActivitySavedDataBinding
import kotlin.system.exitProcess

class SavedDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySavedDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySavedDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }

    fun init() {

        val name = SharedPreferences.getName()
        val age = SharedPreferences.getAge()

        binding.tvNameAndAge.text = "Hola, me llamo $name y tengo $age años"

        binding.btnClose.setOnClickListener {
            SharedPreferences.clearPreferences()
            SharedPreferences.logout()
            finish()
        }
    }

}