package com.oshovenko.cardapp.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.oshovenko.cardapp.data.MainViewModel
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.data.ObservableCard
import com.oshovenko.cardapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        binding.buttonTest.setOnClickListener {buttonTestClick()}

        return binding.root
    }


    private fun buttonTestClick() {
        saveValue()

        findNavController().navigate(R.id.action_mainFragment_to_postcardFragment)
    }

    private fun saveValue() {
        val appSettings: SharedPreferences = this.activity?.getSharedPreferences(sharedPrefsKey, Context.MODE_PRIVATE) as SharedPreferences
        val editor: SharedPreferences.Editor = appSettings.edit()
        editor.putString(titleTextKey, binding.inputTitleText.text.toString())
        editor.putString(nameKey, binding.inputName.text.toString())
        editor.putString(cardTextKey, binding.inputTextCard.text.toString())
        editor.putInt(avatarImageKey, R.drawable.apple)
        editor.putInt(faceImageKey, R.drawable.face)
        editor.putInt(backgroundImageKey,  R.drawable.background_snow)
        editor.apply()
    }

    companion object{
        const val sharedPrefsKey = "appcardsettings"
        const val titleTextKey = "inputTitleText"
        const val nameKey = "inputName"
        const val cardTextKey = "textCard"
        const val avatarImageKey = "avatarImage"
        const val faceImageKey = "faceImage"
        const val backgroundImageKey = "backgroundImage"
    }
}