package com.example.kisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var krepo: KisilerRepository) : ViewModel(){

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
    }
    fun sil(kisi_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.sil(kisi_id)
            //sildikten sonra arayuze guncel listeyi yukleme
            kisileriYukle()
        }
    }
    fun kisileriYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            try {
                kisilerListesi.value = krepo.kisileriYukle()
            }catch (e:Exception){}


        }
    }
    fun ara(aramaKelimesi : String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {//arama sobnucnda degisik bir sonuc gelmemesi için
                kisilerListesi.value = krepo.ara(aramaKelimesi)
            }catch (e:Exception){

            }
        }
    }

}