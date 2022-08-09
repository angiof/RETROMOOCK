package com.example.retromoock.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.retromoock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fraseViewModel: viewModelRetro by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvMainReciver.text = fraseViewModel.lista.observe(this, {
            binding.tvMainReciver.text = it[1].frasi +" " +it[1].autore.toString()
        }).toString()


    }


}
