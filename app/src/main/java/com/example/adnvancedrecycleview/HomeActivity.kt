package com.example.adnvancedrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adnvancedrecycleview.databinding.FragmentHomeActivityBinding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity


class HomeActivity : AppCompatActivity() {


    private lateinit var binding: FragmentActivity
    //private val adapter by lazy { UserAdapter(requireContext(), this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}