package com.example.filmlerapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmlerapp.R
import com.example.filmlerapp.data.entity.Filmler
import com.example.filmlerapp.databinding.CardTasarimBinding
import com.example.filmlerapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmlerAdapter(var mcontext : Context,var filmlerListesi : List<Filmler>)
    :RecyclerView.Adapter<FilmlerAdapter.CardTasarimTutucu>()
{
    //card'ın uzerindeki gorsel nesneleri temsil eden bir clas
    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)
    //tasarim uzerndeki gorsel nesnelere erişme
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mcontext),R.layout.card_tasarim ,parent,false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val film = filmlerListesi.get(position)
        //tasarimdaki gorsellere erisme
        val t = holder.tasarim


        var url = "http://kasimadalan.pe.hu/filmler_yeni/resimler/${film.resim}"
        Glide.with(mcontext).load(url).override(500,750).into(t.imageViewFilm)

        t.filmNesnesi = film

        t.cardViewFilm.setOnClickListener {
            //hangi filmi secersek o filmi bize verecek
            val gecis = AnasayfaFragmentDirections.detayGecis(film = film)
            //detay sayfasina hem veri hem de sayfa yonlendirmesi yapiyor
            Navigation.findNavController(it).navigate(gecis)



        }

        t.buttonSepet.setOnClickListener {
            Snackbar.make(it,"${film.ad} sepete eklendi",Snackbar.LENGTH_SHORT).show()
        }

    }
    override fun getItemCount(): Int {
        return filmlerListesi.size
    }


}