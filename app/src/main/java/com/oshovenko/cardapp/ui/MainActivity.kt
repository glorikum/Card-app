package com.oshovenko.cardapp.ui


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oshovenko.cardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*        val appSettings: SharedPreferences = getSharedPreferences("appcardsettings", Context.MODE_PRIVATE);
        val editor: SharedPreferences.Editor = appSettings.edit()
        editor.putString("APP_PREFERENCES_NAME", "strNickName");
        editor.apply()*/
    }
}