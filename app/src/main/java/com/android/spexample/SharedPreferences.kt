package com.android.spexample

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences {

    companion object {
        private const val PREFERENCES_DATA = "preferencesData"
        private const val KEY_NAME = "name"
        private const val KEY_AGE = "age"

        private lateinit var preferences: SharedPreferences
        private var name: String = ""
        private var age: Int = 0

        fun load(context: Context) {
           preferences = context.applicationContext.getSharedPreferences(PREFERENCES_DATA, Context.MODE_PRIVATE)

            name = preferences.getString(KEY_NAME, "") ?: ""
            age = preferences.getInt(KEY_AGE, 0)

        }

        private fun save(key: String, value: Any) {
            val editor = preferences.edit()
            when (value) {
                is String -> {
                    editor.putString(key, value)
                }
                is Int -> {
                    editor.putInt(key, value)
                }
            }
            editor.apply()
        }

        fun clearPreferences() {
            preferences.edit().clear().apply()
        }

        fun setName(name: String) {
            this.name = name
            save(KEY_NAME, name)
        }

        fun getName() = name

        fun setAge(age: Int) {
            this.age = age
            save(KEY_AGE, age)
        }

        fun getAge() = age

        fun logout() {
            setName("")
            setAge(0)
        }

    }

}