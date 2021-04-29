package com.nuckyboe.kotlin_jetpack_exoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nuckyboe.kotlin_jetpack_exoplayer.databinding.FragmentNav2Binding

class NavFragment2 : Fragment() {
    private lateinit var binding: FragmentNav2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNav2Binding.inflate(layoutInflater)
        binding.page = this
        return binding.root
    }

    fun onClickToNextPage(){
        Navigation.findNavController(binding.root).navigate(R.id.action_navFragment2_to_navFragment3)
    }
}