package com.example.filmler.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.example.filmler.R
import com.example.filmler.databinding.FragmentDetayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
// DetayFragment.kt
class DetayFragment : Fragment() {
    private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay, container, false)

        val bundle : DetayFragmentArgs by navArgs()
        val film = bundle.film

        binding.filmNesnesi=film

        binding.ivFilm.setImageResource(
            resources.getIdentifier(film.resim,"drawable",requireContext().packageName)
        )

        return binding.root
    }
}
