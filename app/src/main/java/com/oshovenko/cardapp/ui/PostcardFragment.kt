package com.oshovenko.cardapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.oshovenko.cardapp.R
import com.oshovenko.cardapp.data.ObservableCard
import com.oshovenko.cardapp.data.PostcardViewModel
import com.oshovenko.cardapp.databinding.FragmentPostcardBinding
import com.oshovenko.cardapp.ui.MainFragment.Companion.avatarImageKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.backgroundImageKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.cardTextKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.faceImageKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.nameKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.sharedPrefsKey
import com.oshovenko.cardapp.ui.MainFragment.Companion.titleTextKey

class PostcardFragment : Fragment() {

    private lateinit var binding: FragmentPostcardBinding
    private val viewModel: PostcardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val observableCard = getCard()

        binding = FragmentPostcardBinding.inflate(inflater)
        binding.card = observableCard
        return binding.root
    }

    private fun getCard(): ObservableCard {
        val appSettings: SharedPreferences = this.activity?.getSharedPreferences(sharedPrefsKey, Context.MODE_PRIVATE) as SharedPreferences

        return ObservableCard(
                appSettings.getString(titleTextKey, "oops"),
                appSettings.getString(nameKey, "oops"),
                appSettings.getString(cardTextKey, "oops"),
                appSettings.getInt(avatarImageKey, R.drawable.background_fire),
                appSettings.getInt(faceImageKey, R.drawable.background_fire),
                appSettings.getInt(backgroundImageKey, R.drawable.background_fire),
        )
    }
}