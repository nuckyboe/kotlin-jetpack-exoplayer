package com.nuckyboe.kotlin_jetpack_exoplayer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class NavFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflate = inflater.inflate(R.layout.fragment_nav2, container,false)
        inflate.findViewById<TextView>(R.id.jump_to_next).setOnClickListener {
            Navigation.findNavController(inflate).navigate(R.id.action_navFragment2_to_navFragment3)
        }
        return inflate
    }
}