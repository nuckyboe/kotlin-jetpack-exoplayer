package com.nuckyboe.kotlin_jetpack_exoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nuckyboe.kotlin_jetpack_exoplayer.databinding.FragmentNav3Binding

class NavFragment3 : Fragment() {
    private lateinit var binding: FragmentNav3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNav3Binding.inflate(layoutInflater)
        binding.page = this
        return binding.root
    }

    fun onClickToNextPage(){
        Navigation.findNavController(binding.root).navigate(R.id.action_navFragment3_to_navFragment1)
    }
}