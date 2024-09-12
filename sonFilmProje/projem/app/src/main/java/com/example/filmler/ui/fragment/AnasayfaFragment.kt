package com.example.filmler.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmler.R
import com.example.filmler.databinding.FragmentAnasayfaBinding
import com.example.filmler.ui.adapter.FilmlerAdapter
import com.example.filmler.ui.viewmodel.AnasayfaViewModel
import com.example.filmler.ui.viewmodel.SepetViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private val viewModel: AnasayfaViewModel by viewModels()
    private val sepetViewModel: SepetViewModel by viewModels({ requireActivity() }) // Shared ViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)

        binding.anasayfaToolBarBaslik = "Filmler"

        viewModel.filmlerListesi.observe(viewLifecycleOwner) {
            val filmlerAdapter = FilmlerAdapter(requireContext(), it, viewModel,sepetViewModel)
            binding.filmlerAdapter = filmlerAdapter
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Kaynakları serbest bırakma veya güncellemeler
    }

}
