package com.example.horoscopop.ui.horoscopo.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopop.databinding.ItemHoroscopoBinding
import com.example.horoscopop.domain.HoroscopoInfo

class HoroscopoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopoBinding.bind(view)
    fun render(horoscopoInfo: HoroscopoInfo){
        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvHoroscopo.text = binding.tvHoroscopo.context.getString(horoscopoInfo.name)
    }
}