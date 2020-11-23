package com.example.adnvancedrecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewpager_main.adapter = MyPagerAdapter(supportFragmentManager)
    }

    fun button(view: View) {
        val intent = Intent(this, HomeActivity::class.java).apply {
        }
        startActivity(intent)
    }
}