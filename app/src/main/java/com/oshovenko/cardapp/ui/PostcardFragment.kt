package com.oshovenko.cardapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.oshovenko.cardapp.data.PostcardViewModel
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.data.ObservableCard
import com.oshovenko.cardapp.databinding.FragmentPostcardBinding

class PostcardFragment : Fragment() {
    private lateinit var binding: FragmentPostcardBinding
    private lateinit var viewModel: PostcardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val observableCard = getCard()
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postcard, container, false)
        viewModel = PostcardViewModel(observableCard)
        binding.card = viewModel
        return binding.root
    }

    private fun getCard(): ObservableCard {
        val appSettings: SharedPreferences = (this.activity?.getSharedPreferences("appcardsettings", Context.MODE_PRIVATE)
                ?: null) as SharedPreferences

        return ObservableCard(
                appSettings.getString("inputTitleText", "oops"),
                appSettings.getString("inputName", "oops"),
                appSettings.getString("textCard", "oops"),
                appSettings.getInt("avatarImage", R.drawable.background_fire),
                appSettings.getString("faceImage", "oops"),
                appSettings.getString("backgroundImage", "oops")
        )
    }
}