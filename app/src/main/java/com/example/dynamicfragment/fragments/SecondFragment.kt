package com.example.dynamicfragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.dynamicfragment.R


class SecondFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        root = inflater.inflate(R.layout.fragment_second, container, false)

        root.findViewById<TextView>(R.id.tv_2).setOnClickListener {
            Toast.makeText(context, "First fragment", Toast.LENGTH_SHORT).show()
        }

        return root
    }

}