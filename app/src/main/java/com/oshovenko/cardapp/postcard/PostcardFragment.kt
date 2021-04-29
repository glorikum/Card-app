package com.oshovenko.cardapp.postcard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.oshovenko.cardapp.BuildConfig
import com.oshovenko.cardapp.databinding.FragmentPostcardBinding
import com.oshovenko.cardapp.imagesource.impl.AssetsImageSource

class PostcardFragment : Fragment() {
    private lateinit var binding: FragmentPostcardBinding
    private val args: PostcardFragmentArgs by navArgs()

    private val viewModel: PostcardViewModel by viewModels {
        PostcardViewModelFactory(
            args.mainModel,
            AssetsImageSource(requireContext(), BuildConfig.IMAGES_PATH),
            AssetsImageSource(requireContext(), BuildConfig.BACKGROUND_PATH),
            AssetsImageSource(requireContext(), BuildConfig.PRESET_PATH)

        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPostcardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}