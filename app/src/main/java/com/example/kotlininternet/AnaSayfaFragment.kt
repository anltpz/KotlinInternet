package com.example.kotlininternet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlininternet.databinding.FragmentAnaSayfaBinding
import com.example.kotlininternet.model.Kitap
import com.example.kotlininternet.network.ApiUtils
import com.example.kotlininternet.response.KitaplarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    var kitaplarList: ArrayList<Kitap> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(layoutInflater)
        kitaplariGetir()
        return binding.root
    }


    private fun kitaplariGetir() {
        ApiUtils.kitaplarDAOInterfaceGetir().kitaplariAl().enqueue(
            object : Callback<KitaplarResponse> {

                ///işlem başarılı ise burada calısacak
                // suan internet izni almadık uygulama calısmaz
                //Anroid manifest dosyasından internet izni almamız gerekiyor
                override fun onResponse(
                    call: Call<KitaplarResponse>,
                    response: Response<KitaplarResponse>
                ) {
                    val tempList = response.body()?.books

                    tempList?.let {
                        kitaplarList = it as ArrayList<Kitap>

                    }
                    val kitapAdapter = KitaplarAdapter(kitaplarList)
                    binding.kitapRV.adapter = kitapAdapter
                    binding.kitapRV.layoutManager = GridLayoutManager(context, 2)
                    binding.kitapRV.setHasFixedSize(true)


                }

                ///bir hata oldugunda burası calısacak
                override fun onFailure(call: Call<KitaplarResponse>, t: Throwable) {

                }

            }

        )
    }

}
