package com.example.horoscopop.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopop.databinding.ItemHoroscopoBinding
import com.example.horoscopop.domain.model.HoroscopoInfo

class HoroscopoViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopoBinding.bind(view)
    fun render(horoscopoInfo: HoroscopoInfo, onItemSelected: (HoroscopoInfo) -> Unit){
        binding.ivHoroscopo.setImageResource(horoscopoInfo.img)
        binding.tvHoroscopo.text = binding.tvHoroscopo.context.getString(horoscopoInfo.name)
        binding.parent.setOnClickListener{
            startRotationAnimation(binding.ivHoroscopo, newLambda = {onItemSelected(horoscopoInfo)})

        }
    }

    fun startRotationAnimation(view: View,newLambda:()-> Unit){

        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction{newLambda()}
            start()
        }

    }
}

