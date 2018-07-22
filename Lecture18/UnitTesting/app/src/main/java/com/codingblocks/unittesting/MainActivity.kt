package com.codingblocks.unittesting

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalcFare.setOnClickListener {
            val km = etKm.text.toString().toFloat()
            val min = etMin.text.toString().toInt()

            val fare = calcFare(km, min)
            tvResult.text = fare.toString()
        }
        if (intent.getStringExtra("RESULT") != null) {
            tvResult.text = intent.getStringExtra("RESULT")
        }
    }
}
