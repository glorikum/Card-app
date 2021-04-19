package com.oshovenko.cardapp.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
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
        observableCard = ObservableCard(
            binding.inputTitleText.toString(),
            binding.inputName.toString(),
            binding.InputTextCard.toString(),
            binding.avatarImage.id,
            binding.faceImage.id,
            binding.backgroundImage.id
        )
        findNavController().navigate(R.id.postcardFragment)
    }

}