package com.example.filmlerapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.filmlerapp.R
import com.example.filmlerapp.databinding.FragmentDetayBinding

class DetayFragment : Fragment() {
        private lateinit var binding: FragmentDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  FragmentDetayBinding.inflate(inflater, container, false)
        //gonderdigi  film nesnesini burada aldık
        val bundle :DetayFragmentArgs by navArgs()
        val film = bundle.film

        binding.toolbarDetaysayfa.title = film.ad

        binding.ivFilm.setImageResource(
            //film nesnesi gelip resme erisicek hangi resim ise onu gorecegiz
            resources.getIdentifier(film.resim,"drawable",requireContext().packageName)
        )
        binding.tvFiyat.text = "${film.fiyat} TL"

        return binding.root
    }
}