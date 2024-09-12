package com.example.filmler.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.filmler.R
import com.example.filmler.databinding.FragmentSepetBinding
import com.example.filmler.ui.adapter.SepetAdapter
import com.example.filmler.ui.model.Filmler
import com.example.filmler.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SepetFragment : Fragment() {

    private lateinit var binding: FragmentSepetBinding
    private lateinit var adapter: SepetAdapter
    private val sepetViewModel: SepetViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sepet, container, false)

        val positionSepet = arguments?.getInt("positionSepet")

        binding.sepetSayfaToolBarBaslik = "Sepet"
        binding.sepetRv.layoutManager = LinearLayoutManager(context)
        adapter = SepetAdapter(requireContext(), listOf())
        binding.sepetRv.adapter = adapter

        sepetViewModel.sepetListesi.observe(viewLifecycleOwner) { filmListesi ->
            adapter.updateList(filmListesi)
        }

        binding.odeme.setOnClickListener {
            Snackbar.make(it, "Ödeme işlemi başlatıldı", Snackbar.LENGTH_SHORT).show()
        }

        return binding.root
    }
}
