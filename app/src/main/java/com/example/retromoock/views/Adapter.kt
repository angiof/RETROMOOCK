package com.example.retromoock.views

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retromoock.databinding.ListaFrasiBinding
import com.example.retromoock.views.network.ResponsesFrasi

class AdapterFrasi :
    ListAdapter<ResponsesFrasi, AdapterFrasi.FrasiViewHolder>((DiffCallBack())) {


    inner class FrasiViewHolder(val listaBing: ListaFrasiBinding) :
        RecyclerView.ViewHolder(listaBing.root) {


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrasiViewHolder {
        val binding =
            ListaFrasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrasiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FrasiViewHolder, position: Int) {
            val entityConfig = getItem(position)

            holder.listaBing.textLista.text = entityConfig.frasi
            Comp.getImg(holder.listaBing.imgList, entityConfig.img?:"")

        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<ResponsesFrasi>() {
        override fun areItemsTheSame(oldItem: ResponsesFrasi, newItem: ResponsesFrasi) =
            oldItem.frasi == newItem.frasi

        override fun areContentsTheSame(oldItem: ResponsesFrasi, newItem: ResponsesFrasi) =
            oldItem == newItem
    }

