package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entitiy.Kisiler
import com.example.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.example.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.example.kisileruygulamasi.viewmodel.AnasayfaViewModel

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding

    private lateinit var viewModel : AnasayfaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())
//        binding.rv.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
//        binding.rv.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)//instagram hikayeler ksımı

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(), it,viewModel)
            binding.rv.adapter = kisilerAdapter
        }

        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayitGecis)
        }
//        binding.buttonDetay.setOnClickListener{
//            val kisi=Kisiler(1,"Baran","777")
//            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi =kisi)
//            Navigation.findNavController(it).navigate(gecis)
//        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {//harf girdikçe ve sildikçe çalışır
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {//arama iconuna bastığında çalışır
                ara(query)
                return false
            }
        })

        return binding.root
    }

override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
    val tempViewModel:AnasayfaViewModel by viewModels()
    viewModel=tempViewModel

}

    fun ara(aramaKelimesi: String) {
        Log.e("Kişi Ara", "$aramaKelimesi")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasafya", "Dönüldü")
    }
}