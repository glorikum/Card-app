package com.oshovenko.cardapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.data.MainViewModel
import com.oshovenko.cardapp.databinding.FragmentMainBinding
import com.squareup.picasso.Picasso


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var bgImage: Array<String>
    private lateinit var itemImage: Array<String>
    private var currentBackground = 0
    private var currentFace = 0
    private val pathToBackground = "file:///android_asset/background/"
    private val pathToItem = "file:///android_asset/item/"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val myAssetManager = context.assets
        bgImage = myAssetManager.list("background") as Array<String>
        itemImage = myAssetManager.list("item") as Array<String>
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.buttonTest.setOnClickListener { buttonTestClick() }
        binding.backgroundImage.setOnClickListener { changeBackground() }
        binding.faceButtonRight.setOnClickListener { changeFacePlus() }
        binding.faceButtonLeft.setOnClickListener { changeFaceMinus() }

        setBackground()
        setFace()
        return binding.root
    }

    private fun setFace() {
        Picasso.get()
                .load(pathToItem + itemImage[currentFace])
                .resize(200,200)
                .into(binding.faceImage)
    }

    private fun changeFacePlus() {
        currentFace++
        if (currentFace == itemImage.size) {
            currentFace = 0
        }
        setFace()
    }

    private fun changeFaceMinus() {
        currentFace--
        if (currentFace < 0) {
            currentFace = itemImage.size - 1
        }
        setFace()
    }

    private fun setBackground() {
        Picasso.get()
                .load(pathToBackground + bgImage[currentBackground])
                .into(binding.backgroundImage)
    }

    private fun changeBackground() {
        currentBackground++
        if (currentBackground == bgImage.size) {
            currentBackground = 0
        }
        setBackground()
    }

    private fun buttonTestClick() {
        saveValue()
        findNavController().navigate(R.id.postcardFragment)
    }

    private fun saveValue() {
        val appSettings: SharedPreferences = (this.activity?.getSharedPreferences("appcardsettings", Context.MODE_PRIVATE)
                ?: null) as SharedPreferences
        val editor: SharedPreferences.Editor = appSettings.edit()
        editor.putString("inputTitleText", binding.inputTitleText.text.toString())
        editor.putString("inputName", binding.inputName.text.toString())
        editor.putString("textCard", binding.inputTextCard.text.toString())
        editor.putInt("avatarImage", R.drawable.apple)
        editor.putString("faceImage", itemImage[currentFace])
        editor.putString("backgroundImage", bgImage[currentBackground])
        editor.apply()
    }
}