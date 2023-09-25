package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {

    suspend fun kaydet(kisi_ad:String, kisi_tel:String){
        Log.e("Kişi Kaydet", "$kisi_ad - $kisi_tel")
    }


   suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        Log.e("Kişi Güncelle", "$kisi_id - $kisi_ad - $kisi_tel")
    }

    suspend fun sil(kisi_id: Int) {
        Log.e("Kişi Sil", kisi_id.toString())
    }

    suspend fun kisileriYukle(): List<Kisiler> = withContext(Dispatchers.IO){
        val liste = ArrayList<Kisiler>()
        val k1 = Kisiler(1, "Baran", "777")
        val k2 = Kisiler(2, "Özge", "444")
        val k3 = Kisiler(3, "Ozan", "888")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)

        return@withContext liste
    }
}