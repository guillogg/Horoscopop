package com.example.horoscopop.ui.horoscopo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscopop.databinding.FragmentHoroscopoBinding
import com.example.horoscopop.domain.model.HoroscopoInfo
import com.example.horoscopop.domain.model.HoroscopoModel
import com.example.horoscopop.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<HoroscopoViewModel>()

    private lateinit var horoscopoAdapter: HoroscopoAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initRecyclerView()
        initUIState()
    }

    private fun initRecyclerView() {
        horoscopoAdapter = HoroscopoAdapter(onItemSelected = {
            val type =  when (it){
                HoroscopoInfo.Acuario -> HoroscopoModel.Acuario
                HoroscopoInfo.Aries -> HoroscopoModel.Aries
                HoroscopoInfo.Cancer -> HoroscopoModel.Cancer
                HoroscopoInfo.Capricornio -> HoroscopoModel.Capricornio
                HoroscopoInfo.Escorpio -> HoroscopoModel.Escorpio
                HoroscopoInfo.Geminis -> HoroscopoModel.Geminis
                HoroscopoInfo.Leo -> HoroscopoModel.Leo
                HoroscopoInfo.Libra -> HoroscopoModel.Libra
                HoroscopoInfo.Picis -> HoroscopoModel.Piscis
                HoroscopoInfo.Sagitario -> HoroscopoModel.Sagitario
                HoroscopoInfo.Tauro -> HoroscopoModel.Tauro
                HoroscopoInfo.Virgo -> HoroscopoModel.Virgo
            }

            findNavController().navigate(
                HoroscopoFragmentDirections.actionHoroscopoFragmentToDetailActivity(type)
            )
        })
        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoAdapter
        }

    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopo.collect() {
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}