package com.example.horoscopop.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.example.horoscopop.R
import com.example.horoscopop.databinding.ActivityDetailBinding
import com.example.horoscopop.domain.model.HoroscopoModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val DetailViewModel by viewModels<DetailViewModel>()
    private val args: DetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        InitUI()
        DetailViewModel.getHoroscope(args.type)
    }

    private fun InitUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                DetailViewModel.state.collect {
                    when (it) {
                        DetailState.Loading -> LoadingState()
                        is DetailState.Error -> ErrorState()
                        is DetailState.Success -> succesState(it)
                    }
                }
            }
        }
    }

    private fun LoadingState() {
        binding.pb.isVisible = true
    }

    private fun ErrorState() {
        binding.pb.isVisible = false
    }

    private fun succesState(state: DetailState.Success) {
        binding.pb.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
       val image=when(state.horoscopoModel){
            HoroscopoModel.Aries -> R.drawable.detail_aries
            HoroscopoModel.Taurus -> R.drawable.detail_taurus
            HoroscopoModel.Gemini -> R.drawable.detail_gemini
            HoroscopoModel.Cancer -> R.drawable.detail_cancer
            HoroscopoModel.Leo -> R.drawable.detail_leo
            HoroscopoModel.Virgo -> R.drawable.detail_virgo
            HoroscopoModel.Libra -> R.drawable.detail_libra
            HoroscopoModel.Scorpio -> R.drawable.detail_scorpio
            HoroscopoModel.Saggitarius -> R.drawable.detail_sagittarius
            HoroscopoModel.Capricorn -> R.drawable.detail_capricorn
            HoroscopoModel.Aquiarius -> R.drawable.detail_aquarius
            HoroscopoModel.Pisces -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }
}