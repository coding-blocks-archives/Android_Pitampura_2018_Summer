package com.codingblocks.camera

import android.Manifest
import android.content.pm.PackageManager
import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.SurfaceHolder
import android.view.Window
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SurfaceHolder.Callback {
    lateinit var cam: Camera

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {

        holder?.let { it.surface?.let {
            try {
                cam.stopPreview()
            } catch (e: Exception) {}

            try {
                cam.setDisplayOrientation(90)
                cam.setPreviewDisplay(holder)
                cam.startPreview()
            } catch (e: Exception) {}
        }

        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {
        cam.setDisplayOrientation(90)
        cam.setPreviewDisplay(svCameraPreview.holder)
        cam.startPreview()
    }

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

                cam = Camera.open(0)
                Log.d("CAM", """

                    Picture Size =
                    ${cam.parameters.pictureSize.height} x ${cam.parameters.pictureSize.width}

                    Preview Size =
                    ${cam.parameters.previewSize.height} x ${cam.parameters.previewSize.width}
                """.trimIndent())

                cam.parameters.supportedPictureSizes.forEach {
                    Log.d("CAM", "SIZE : ${it.height} x ${it.width}")
                }
                cam.parameters.supportedPreviewSizes.forEach {
                    Log.d("CAM", "PREVIEW : ${it.height} x ${it.width}")
                }

                svCameraPreview.holder.addCallback(this)
                cam.setDisplayOrientation(90)
                cam.setPreviewDisplay(svCameraPreview.holder)
                cam.startPreview()

            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
