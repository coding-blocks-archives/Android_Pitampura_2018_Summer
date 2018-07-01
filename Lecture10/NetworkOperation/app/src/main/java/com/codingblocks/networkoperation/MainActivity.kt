package com.codingblocks.networkoperation

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnView.setOnClickListener {
            DownloadTask().execute(etUrl.text.toString())
        }

    }

    inner class DownloadTask: AsyncTask<String, Unit, String>() {


        override fun doInBackground(vararg params: String?): String {
            if (params.size < 1) return "NO URL FOUND"

            try {
                val url = URL(params[0])
                val connection = url.openConnection() as HttpURLConnection
                val br = BufferedReader(InputStreamReader(connection.inputStream))
                val sb = StringBuilder()
                var buf = br.readLine()
                while (buf != null) {
                    sb.append(buf)
                    buf = br.readLine()
                }
                return sb.toString()
            } catch (e: IOException) {
                Log.e("NET", "ERROR READING DATA", e)
                return "ERROR READING DATA"
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            tvData.text = result
        }
    }
}
