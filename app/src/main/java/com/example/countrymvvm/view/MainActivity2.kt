package com.example.countrymvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.countrymvvm.R
import kotlinx.android.synthetic.main.activity_country_details.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_details)

        val name= intent.getStringExtra("name")
        countryName.text = name
    }
}