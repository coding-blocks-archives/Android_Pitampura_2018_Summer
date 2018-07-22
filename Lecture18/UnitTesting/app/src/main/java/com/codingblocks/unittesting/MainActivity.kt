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

    companion object {
        @JvmStatic
        fun calcFare(km: Float, min: Int): Float {
            var fare = 60f
            if (km > 5) fare += (km -5) * 10
            if (min > 30) fare += (min - 30) * 2
            return fare
        }
    }
}
