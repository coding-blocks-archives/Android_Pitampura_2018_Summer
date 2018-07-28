package com.codingblocks.camera

import android.Manifest
import android.content.pm.PackageManager
import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                123
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {

        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                val cam = Camera.open()
                Log.d("CAM", """
                    Picture Size = ${cam.parameters.pictureSize}
                    Preview Size = ${cam.parameters.previewSize}
                """.trimIndent())
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
