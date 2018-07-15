package com.codingblocks.hardwaresensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sm = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        for (sensor in sm.getSensorList(Sensor.TYPE_ALL)) {
            Log.d("SENSOR", """
                ===========================
                name = ${sensor.name}
                type = ${sensor.stringType}
                vendor = ${sensor.vendor}
                ===========================
            """.trimIndent())
        }

        val accelSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        val sensorListener = object: SensorEventListener {
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

            override fun onSensorChanged(event: SensorEvent?) {
                event?.apply {
                    Log.d("SENSOR", """
                        ax = ${values[0]}
                        ay = ${values[1]}
                        az = ${values[2]}
                    """.trimIndent())
                }
            }

        }

        sm.registerListener(
                sensorListener,
                accelSensor,
                1000 * 1000
        )

    }
}
