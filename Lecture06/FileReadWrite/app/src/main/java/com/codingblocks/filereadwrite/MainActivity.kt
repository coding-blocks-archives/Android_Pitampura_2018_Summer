package com.codingblocks.filereadwrite

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    val TAG = "FILES"

    fun writeFile () {
        val file = File(Environment.getExternalStorageDirectory(), "myfile.txt")
        val fos = FileOutputStream(file, true) // this makes us append
        fos.write(etInput.text.toString().toByteArray())
        fos.close() // good practice to do this manually
    }

    fun readFile () {
        try {
            val file = File(Environment.getExternalStorageDirectory(), "myfile.txt")
            val fis = FileInputStream(file)
//            file.readBytes()
            val br = BufferedReader(InputStreamReader(fis))
            var buf: String? = ""
            val sb = StringBuilder()
            while (buf != null) {
                sb.append(buf)
                buf=br.readLine()
            }
            fis.close() // good practice to do this manually
            etInput.setText(sb.toString())
        } catch (e: IOException) {
            Toast
                    .makeText(this, "Could not read file", Toast.LENGTH_SHORT)
                    .show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnWrite.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED) {
                writeFile()
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                        111
                )
            }
        }

        btnRead.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                    ) == PackageManager.PERMISSION_GRANTED) {
                readFile()
            } else {
                ActivityCompat.requestPermissions(
                        this,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        112
                )
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            111 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    writeFile()
                } else {
                    Toast.makeText(
                            this,
                            "No permission to write file",
                            Toast.LENGTH_SHORT)
                            .show()
                }
            }
            112 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readFile()
                }else {
                    Toast.makeText(
                            this,
                            "No permission to read file",
                            Toast.LENGTH_SHORT)
                            .show()
                }
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
