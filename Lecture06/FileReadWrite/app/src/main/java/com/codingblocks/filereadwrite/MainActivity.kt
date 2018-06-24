package com.codingblocks.filereadwrite

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "FILES"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, """
            getDataDirectory = ${Environment.getDataDirectory()}
            getExternalStorageDirectory = ${Environment.getExternalStorageDirectory()}
            getExternalFilesDir = ${getExternalFilesDir(null)}
        """.trimIndent())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Log.d(TAG, """
                dataDir = ${dataDir}
                filesDir = ${filesDir}
                getExternalFilesDirs ${getExternalFilesDirs(null).toList()}
            """.trimIndent())
        }

    }
}
