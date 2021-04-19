package com.oshovenko.cardapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.oshovenko.cardapp.data.PostcardViewModel
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.databinding.FragmentPostcardBinding

class PostcardFragment : Fragment() {
    private lateinit var binding: FragmentPostcardBinding
    private lateinit var viewModel: PostcardViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_postcard, container, false)
        viewModel = ViewModelProvider(this).get(PostcardViewModel()::class.java)
        binding.card = viewModel
        return binding.root
    }
}