package com.example.filmler.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler.R
import com.example.filmler.databinding.CardTasarimBinding
import com.example.filmler.ui.fragment.AnasayfaFragmentDirections
import com.example.filmler.ui.model.Filmler
import com.example.filmler.ui.viewmodel.AnasayfaViewModel
import com.example.filmler.ui.viewmodel.FavoriViewModel
import com.example.filmler.ui.viewmodel.SepetViewModel
import com.google.android.material.snackbar.Snackbar
class FilmlerAdapter(
    private val mContext: Context,
    private val filmlerListesi: List<Filmler>,
    private val viewModel: AnasayfaViewModel,
    private val sepetViewModel: SepetViewModel

) : RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(val tasarim: CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding: CardTasarimBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext), R.layout.card_tasarim, parent, false
        )
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi[position]
        val t = holder.tasarim

        t.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.resim, "drawable", mContext.packageName)
        )

        t.filmNesnesi = film

        t.cardViewFilm.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayGecis(film)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.ikon.setOnClickListener {
            viewModel.filmFavorilereEkle(film)
            Snackbar.make(it, "${film.ad} favorilere eklendi", Snackbar.LENGTH_SHORT).show()
           val action = AnasayfaFragmentDirections.actionAnasayfaFragmentToFavoriFragment(favori = film,position=position)
           Navigation.findNavController(it).navigate(action)
        }

        t.buttonSepet.setOnClickListener {
            sepetViewModel.ekleSepete(film)
            Snackbar.make(it, "${film.ad} sepete eklendi", Snackbar.LENGTH_SHORT).show()
            val action = AnasayfaFragmentDirections.actionAnasayfaFragmentToSepetFragment(sepet = film, positionSepet = position)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return filmlerListesi.size
    }
}
