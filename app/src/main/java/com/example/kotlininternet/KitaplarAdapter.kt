package com.example.kotlininternet

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlininternet.databinding.KitapCardBinding
import com.example.kotlininternet.model.Kitap
import com.squareup.picasso.Picasso

class KitaplarAdapter(private  var kitaplarList:ArrayList<Kitap>)
    :RecyclerView.Adapter<KitaplarAdapter.KitapCardDesing>()
{
    class KitapCardDesing(val kitapCardBinding:KitapCardBinding)
        :RecyclerView.ViewHolder(kitapCardBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitapCardDesing {

        val layoutInflater=LayoutInflater.from(parent.context)
        val kitapCardBinding =KitapCardBinding.inflate(layoutInflater,parent,false)
        return  KitapCardDesing(kitapCardBinding)
    }

    override fun onBindViewHolder(holder: KitapCardDesing, position: Int) {
      val kitap=kitaplarList[position]
        holder.kitapCardBinding.apply {
            kitapAdText.text=kitap.book_name
            Picasso.get().load(kitap.book_image_url).into(kitapImageView)

        }
    }

    override fun getItemCount(): Int {

        return kitaplarList.size
    }


}