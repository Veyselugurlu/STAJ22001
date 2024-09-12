package com.example.filmler.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmler.R
import com.example.filmler.databinding.FragmentFavoriBinding
import com.example.filmler.ui.adapter.FavorilerAdapter
import com.example.filmler.ui.viewmodel.FavoriViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.InvocationTargetException

@AndroidEntryPoint
class FavoriFragment : Fragment() {

    private lateinit var binding: FragmentFavoriBinding
    private val favoriViewModel: FavoriViewModel by viewModels() // favoriViewModel burada tanımlandı
    private val args: FavoriFragmentArgs by navArgs() // Argümanları almak için navArgs kullanımı

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favori, container, false)

        binding.rvFavori.layoutManager = LinearLayoutManager(requireContext())
        val adapter = FavorilerAdapter(requireContext(), emptyList())
        binding.rvFavori.adapter = adapter

        //burda getile favoriye ekledigim card alıncak

        binding.favBaslik = "Favoriler"   //Data Binding

        favoriViewModel.getFavoriteFilms()
        favoriViewModel.favoriFilmlerListesi.observe(viewLifecycleOwner) { favoriFilmler ->
            adapter.filmFavoriListesi = favoriFilmler
            adapter.notifyDataSetChanged()
        }

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                ara(query ?: "")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                ara(newText ?: "")
                return true
            }
        })

        return binding.root
    }

    private fun ara(aramaKelimesi: String) {
        Log.e("Film Ara", aramaKelimesi)
        // Arama kelimesine göre filtreleme yapma kodunu buraya ekleyin.
    }
}
