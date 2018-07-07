package com.codingblocks.googlemaps

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val delhi = LatLng(28.0, 77.0)
        mMap.addMarker(MarkerOptions().position(delhi).title("Marker near Delhi"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(delhi, 14f))

        mMap.addCircle(
                CircleOptions()
                        .center(delhi)
                        .radius(100.0)
                        .strokeColor(Color.BLACK)
                        .fillColor(Color.argb(50, 100, 50, 50))
                        .strokeWidth(1f)
        )

        mMap.addPolyline(
                PolylineOptions()
                        .add(delhi)
                        .add(LatLng(delhi.latitude, delhi.longitude + 1))
                        .add(LatLng(delhi.latitude + 1, delhi.longitude + 1))
                        .add(LatLng(delhi.latitude + 1, delhi.longitude))
                        .color(Color.BLUE)
                        .width(5f)
        )
    }
}
