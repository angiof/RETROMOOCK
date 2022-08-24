package com.example.retromoock.views

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.retromoock.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var imageView: ImageView = findViewById(R.id.imageView_des)
        var des: TextView = findViewById(R.id.textView_des)

        des.text = intent.getStringExtra("d")
        Comp.getImg(imageView,intent.getStringExtra("i").toString())


    }
}