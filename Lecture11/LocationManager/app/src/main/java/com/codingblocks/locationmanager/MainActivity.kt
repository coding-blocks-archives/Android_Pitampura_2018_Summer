package com.codingblocks.locationmanager

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "LOC"
    lateinit var locMan: LocationManager
    lateinit var locLis: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locLis = object: LocationListener {
            override fun onLocationChanged(location: Location?) {
                Log.d(TAG, """
                    provider = ${location?.provider}
                    latitude = ${location?.latitude}
                    longitude = ${location?.longitude}
                    altitude = ${location?.altitude}
                    accuracy = ${location?.accuracy}
                """.trimIndent())
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }

        }

        val coarsePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
        val finePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)

        ActivityCompat.requestPermissions(
                this,
                arrayOf(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ),
                212
        )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 212) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locMan = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                locMan.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        1000,
                        10f,
                        locLis
                )
            }
            if (grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                locMan = getSystemService(Context.LOCATION_SERVICE) as LocationManager
                locMan.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        1000,
                        10f,
                        locLis
                )
            }
        }
    }
}
