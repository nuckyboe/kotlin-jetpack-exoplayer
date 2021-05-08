package com.nuckyboe.kotlin_jetpack_exoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.nuckyboe.kotlin_jetpack_exoplayer.databinding.FragmentNav1Binding

class NavFragment1 : Fragment() {

    private lateinit var binding:FragmentNav1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNav1Binding.inflate(layoutInflater)
        binding.page = this
        return binding.root
    }

    fun onClickToNextPage(){
        Navigation.findNavController(binding.root).navigate(R.id.action_navFragment1_to_navFragment2)
    }

    fun onClickToNextActivity(){
        Navigation.findNavController(binding.root).navigate(R.id.action_navFragment1_to_ioc_activity)
    }
}