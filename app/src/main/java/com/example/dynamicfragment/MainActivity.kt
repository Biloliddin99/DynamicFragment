package com.example.dynamicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dynamicfragment.databinding.ActivityMainBinding
import com.example.dynamicfragment.fragments.FirstFragment
import com.example.dynamicfragment.fragments.SecondFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    private var added = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        val fragmentManager = supportFragmentManager

        binding.btnAdd.setOnClickListener {
            if (!added) {
                fragmentManager.beginTransaction()
                    .add(R.id.background, firstFragment)
                    .commit()
                added = true
            }
        }

        binding.btnRemove.setOnClickListener {
            fragmentManager.beginTransaction()
                .remove(firstFragment)
                .commit()
            added = false
        }

        binding.btnReplace.setOnClickListener {
            fragmentManager.beginTransaction()
                .replace(R.id.background, secondFragment)
                .addToBackStack(secondFragment.toString())
                .commit()
        }

        binding.btnHide.setOnClickListener {
            fragmentManager.beginTransaction()
                .hide(firstFragment)
                .commit()
        }

        binding.btnShow.setOnClickListener {
            fragmentManager.beginTransaction()
                .show(firstFragment)
                .commit()
        }

    }
}