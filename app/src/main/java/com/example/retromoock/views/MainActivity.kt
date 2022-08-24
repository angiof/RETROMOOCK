package com.example.retromoock.views

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.retromoock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var fraseViewModel: viewModelRetro
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fraseViewModel  = ViewModelProvider(this)[viewModelRetro::class.java]


        val adapterFrasi: AdapterFrasi = AdapterFrasi()

        fraseViewModel.lista.observe(this) {
            adapterFrasi.submitList(it)
        }
        binding.recyMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.setHasFixedSize(true)
            this.adapter = adapterFrasi


        }


    }


}

class Comp() {

    companion object Imagess {
        fun getImg(imageView: ImageView, url: String) =
            Glide.with(imageView.context).load(url).into(imageView)
    }
}