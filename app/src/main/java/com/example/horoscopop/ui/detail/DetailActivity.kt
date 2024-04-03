package com.example.horoscopop.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavArgs
import androidx.navigation.navArgs
import com.example.horoscopop.R
import com.example.horoscopop.databinding.ActivityDetailBinding
import com.example.horoscopop.databinding.ActivityMainBinding
import com.example.horoscopop.ui.horoscopo.HoroscopoViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
    }

    private fun InitUI() {

        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                DetailViewModel.state.collect {
                    when (it) {
                        is DetailState.Error -> LoadingState()

                        DetailState.Loading -> ErrorState()



                        is DetailState.Success -> succesState()
                    }
                }
            }
        }
    }

    private fun LoadingState() {
        binding.pb.isVisible = true
    }

    private fun ErrorState() {

    }

    private fun succesState() {

    }
}