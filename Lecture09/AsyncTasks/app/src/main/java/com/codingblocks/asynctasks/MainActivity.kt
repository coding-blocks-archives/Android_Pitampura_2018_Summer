package com.codingblocks.asynctasks

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() - start < 5000);
            textView.text = "DONE"
        }

        btnCount.setOnClickListener {
            counter++
            tvCounter.text  = counter.toString()
        }


    }
}
