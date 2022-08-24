package com.example.retromoock.views

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.retromoock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fraseViewModel: viewModelRetro by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tvMainReciver.text = fraseViewModel.lista.observe(this) {
            binding.tvMainReciver.text = it[0].frasi + " " + it[0].autore.toString()
            //popola la img
            Comp.getImg(binding.imgMain, it[0].img)
            val imgUrl: String = it[0].img
            val des: String = it[0].des
            binding.imgMain.setOnClickListener { it ->
                val intent: Intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("i", imgUrl)
                intent.putExtra("d", des)
                startActivity(intent)
            }

        }.toString()


    }


}


class Comp() {

    companion object Imagess {
        fun getImg(imageView: ImageView, url: String) =
            Glide.with(imageView.context).load(url).into(imageView)
    }
}