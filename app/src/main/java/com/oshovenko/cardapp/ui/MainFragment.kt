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
import androidx.navigation.fragment.findNavController
import com.oshovenko.cardapp.data.MainViewModel
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.data.ObservableCard
import com.oshovenko.cardapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    private lateinit var viewModel: MainViewModel
    lateinit var observableCard: ObservableCard

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.buttonTest.setOnClickListener {buttonTestClick()}

        return binding.root
    }


    private fun buttonTestClick() {
        saveValue()

        findNavController().navigate(R.id.postcardFragment)
    }

    private fun saveValue() {
        val appSettings: SharedPreferences = (this.activity?.getSharedPreferences("appcardsettings", Context.MODE_PRIVATE)
                ?: null) as SharedPreferences
        val editor: SharedPreferences.Editor = appSettings.edit()
        editor.putString("inputTitleText", binding.inputTitleText.text.toString());
        editor.putString("inputName", binding.inputName.text.toString());
        editor.putString("textCard", binding.inputTextCard.text.toString());
        editor.putInt("avatarImage", R.drawable.apple);
        editor.putInt("faceImage", R.drawable.fjb1);
        editor.putInt("backgroundImage",  R.drawable.background_snow);
        editor.apply()
    }

}