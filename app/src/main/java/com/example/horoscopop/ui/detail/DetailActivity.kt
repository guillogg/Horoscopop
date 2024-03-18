package com.example.horoscopop.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.example.horoscopop.R
import com.example.horoscopop.databinding.ActivityDetailBinding
import com.example.horoscopop.databinding.ActivityMainBinding
import com.example.horoscopop.ui.horoscopo.HoroscopoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val DetailViewModel by viewModels<DetailViewModel>()
    private val args: DetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
    }
}