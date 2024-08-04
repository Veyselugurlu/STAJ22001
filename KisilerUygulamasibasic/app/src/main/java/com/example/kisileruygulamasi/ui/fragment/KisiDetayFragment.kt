package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import androidx.navigation.fragment.navArgs

class KisiDetayFragment : Fragment() {
    private lateinit var binding: FragmentKisiDetayBinding
    private val args: KisiDetayFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKisiDetayBinding.inflate(inflater, container, false)

        binding.toolbarKisiDetay.title = "Kişi Detay"

        val gelenKisi = args.kisi

        binding.editextKisiAd.setText(gelenKisi.kisi_ad)
        binding.editTextKisiTel.setText(gelenKisi.kisi_tel)

        return binding.root
    }
    fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        Log.e("kişi guncelle","$kisi_id - $kisi_ad -$kisi_tel")
    }
}

