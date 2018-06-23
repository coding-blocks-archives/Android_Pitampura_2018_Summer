package com.codingblocks.intents

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MAINACT"
    lateinit var actIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpen.setOnClickListener({
            actIntent = Intent(this, OtherActivity::class.java)
            val something = etSomething.text.toString()
            actIntent.putExtra("DATA", something)
            startActivity(actIntent)
        })
        btnDial.setOnClickListener {
            val phno = etPhNo.text.toString()
            actIntent = Intent(Intent.ACTION_CALL)
            actIntent.data = Uri.parse("tel:"+phno)
            val perm = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
            if (perm == PackageManager.PERMISSION_GRANTED) {
                startActivity(actIntent)
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(
                                Manifest.permission.CALL_PHONE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE
                                ),
                        231
                )
            }
        }


    }

    override fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray) {

        if (requestCode == 231) {
            Log.d("PERM", grantResults.toList().toString())

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                startActivity(actIntent)
            } else {
                Toast.makeText(
                        this,
                        "Cannot dial without permission",
                        Toast.LENGTH_SHORT)
                        .show()
                actIntent.action = Intent.ACTION_DIAL
                startActivity(actIntent)
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
