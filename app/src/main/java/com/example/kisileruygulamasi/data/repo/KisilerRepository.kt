package com.example.kisileruygulamasi.data.repo

import android.util.Log
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource

class KisilerRepository {
    var kds = KisilerDataSource()
    suspend fun kaydet(kisi_ad: String, kisi_tel: String) = kds.kaydet(kisi_ad, kisi_tel)

    suspend fun guncelle(kisi_id: Int, kisi_ad: String, kisi_tel: String) =
        kds.guncelle(kisi_id, kisi_ad, kisi_tel)
}