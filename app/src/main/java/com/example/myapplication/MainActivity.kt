package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var BASE_URL: String = "http://apimeme.com/meme"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getMeme()
    }

    private fun getMeme() {
        binding.apply {
           getMeme.setOnClickListener {
               giveMe()
           }
        }
    }

    private fun giveMe() {
        binding.apply {
            val textTop = text1.text
            val textBottom = text2.text
            val imageMeme = spinner.selectedItem.toString().replace(" " , "-")
            val url = "$BASE_URL?meme=$imageMeme&top=$textTop&bottom=$textBottom"
               load(url)


        }

    }

    private fun load(url: String) {
        Glide.with(this)
            .load(url)
            .into(binding.imageMeme)

    }

}
