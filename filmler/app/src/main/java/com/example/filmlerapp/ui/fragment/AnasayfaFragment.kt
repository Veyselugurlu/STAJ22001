package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.FragmentAnasayfaBinding
import com.example.filmlerapp.ui.adapter.FilmlerAdapter

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)
        binding.filmRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.toolbarAnasayfa.title = "Filmler"
        val filmlerListesi = ArrayList<Filmler>()
        val f1 = Filmler(1,"Django","django",240)
        val f2= Filmler(2,"Intersteller","interstellar",99)
        val f3 = Filmler(3,"Inception","inception",199)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",85)
        val f5 = Filmler(5,"The Pianist","thepianist",180)
        val f6 = Filmler(6,"Anadoluda","anadoluda",100)
        filmlerListesi.add(f1)
        filmlerListesi.add(f2)
        filmlerListesi.add(f3)
        filmlerListesi.add(f4)
        filmlerListesi.add(f5)
        filmlerListesi.add(f6)

        val filmlerAdapter = FilmlerAdapter(requireContext(),filmlerListesi)
        binding.filmRv.adapter = filmlerAdapter



        return  binding.root








    }

}