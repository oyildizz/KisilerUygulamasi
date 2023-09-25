package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {
    var krepo = KisilerRepository()

     fun sil(kisi_id: Int) {
      CoroutineScope(Dispatchers.Main).launch {
          krepo.sil(kisi_id)
      }
    }
}