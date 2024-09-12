package com.example.filmler.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.filmler.R
import com.example.filmler.databinding.SepetTasarimBinding
import com.example.filmler.ui.model.Filmler

class SepetAdapter(
    private val context: Context,
    private var filmSepetListesi: List<Filmler>
) : RecyclerView.Adapter<SepetAdapter.SepetViewHolder>() {

    inner class SepetViewHolder(var tasarimBinding: SepetTasarimBinding) : RecyclerView.ViewHolder(tasarimBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: SepetTasarimBinding = DataBindingUtil.inflate(inflater, R.layout.sepet_tasarim, parent, false)
        return SepetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        val film = filmSepetListesi[position]
        Log.d("film: ", film.ad)
        val t = holder.tasarimBinding
        t.film = film
        // Sepet card yapısı özellikleri
        t.imageView2.setImageResource(
            context.resources.getIdentifier(film.resim, "drawable", context.packageName)
        )
        // Buton tıklama ve sayaç işlemleri
        var count = 1
        t.filmFiyatSepet.text = (film.fiyat * count).toString()
        t.filmAdiSepet.text = film.ad

        t.sayac.text = count.toString()

        t.buttonArttir.setOnClickListener {
            count++
            val yeniFiyat= film.fiyat * count
            t.filmFiyatSepet.text= yeniFiyat.toString()
            t.sayac.text = count.toString()
        }

        // Sil butonu tıklama işlemi
        t.ivSilSepet.setOnClickListener {
            // Silme işlemini burada yapabilirsiniz
        }
    }

    override fun getItemCount(): Int {
        return filmSepetListesi.size
    }

    fun updateList(newList: List<Filmler>) {
        filmSepetListesi = newList
        notifyDataSetChanged()
    }
}
