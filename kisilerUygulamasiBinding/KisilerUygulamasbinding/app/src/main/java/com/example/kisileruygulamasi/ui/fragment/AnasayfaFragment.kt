package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.example.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment = this
        binding.anasayfaToolBarBaslik = "Kisiler"

        //LİVEDATA yapisi kurma
        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            //kisileri goruntuleme
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = kisilerAdapter
        }


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //harf girildikçe calisir
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }
            //girilen degeri getirir
            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        } )

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)

    }
    //girilen degeri fonksiyona akrtariririz
    fun ara(aramaKelimesi : String){
        Log.e("Kisi Ara",aramaKelimesi)
    }

}