package com.codingblocks.filereadwrite

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    val TAG = "FILES"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWrite.setOnClickListener {

            val file = File(filesDir, "myfile.txt")
            val fos = FileOutputStream(file)
            fos.write(etInput.text.toString().toByteArray())
            fos.close() // good practice to do this manually
        }

        btnRead.setOnClickListener {
            try {
                val file = File(filesDir, "myfile.txt")
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


    }
}
