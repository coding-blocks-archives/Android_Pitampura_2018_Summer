package com.codingblocks.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sPref = getPreferences(Context.MODE_PRIVATE)

        btnSave.setOnClickListener {
            sPref.edit()
                    .putString("DATA", etText.text.toString())
                    .apply()
        }

        btnRetrieve.setOnClickListener {
            etText.setText(
                    sPref.getString("DATA", "")
            )
        }
    }
}
