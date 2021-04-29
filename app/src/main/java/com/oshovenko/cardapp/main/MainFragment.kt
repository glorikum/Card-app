package com.oshovenko.cardapp.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.oshovenko.cardapp.BuildConfig
import com.oshovenko.cardapp.databinding.FragmentMainBinding
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory(
        AssetsImageSource(requireContext(), BuildConfig.IMAGES_PATH),
        AssetsImageSource(requireContext(), BuildConfig.BACKGROUND_PATH),
        AssetsImageSource(requireContext(), BuildConfig.PRESET_PATH)
    ) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigationLiveEvent.observe(viewLifecycleOwner, ::navigate)
    }
    private fun navigate(direction: NavDirections) {
        findNavController().navigate(direction)
    }
}