package com.codingblocks.intents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        intent?.let {
            val something = it.getStringExtra("DATA")
            tv1.text = something
        }
    }
}
