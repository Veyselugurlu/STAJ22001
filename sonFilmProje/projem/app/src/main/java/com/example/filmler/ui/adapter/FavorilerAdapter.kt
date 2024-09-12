package com.example.filmler.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler.databinding.FavoriTasarimBinding
import com.example.filmler.ui.model.Filmler

class FavorilerAdapter(
    var mContext: Context,
    var filmFavoriListesi: List<Filmler>
) : RecyclerView.Adapter<FavorilerAdapter.FavoriTasarimTutucu>() {

    inner class FavoriTasarimTutucu(var tasarim: FavoriTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriTasarimTutucu {
        val binding = FavoriTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return FavoriTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: FavoriTasarimTutucu, position: Int) {
        val film = filmFavoriListesi[position]
        val t = holder.tasarim

        t.imageView.setImageResource(
            mContext.resources.getIdentifier(film.resim, "drawable", mContext.packageName)
        )
        t.textViewFilmAdi.text = film.ad
        t.textViewFilmFiyat.text = "${film.fiyat} ₺"

    }

    override fun getItemCount(): Int {
        return filmFavoriListesi.size
    }
}
