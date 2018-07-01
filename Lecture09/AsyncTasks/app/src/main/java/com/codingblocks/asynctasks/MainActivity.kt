package com.codingblocks.asynctasks

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener {
            WaitTask().execute()
        }

        btnCount.setOnClickListener {
            counter++
            tvCounter.text  = counter.toString()
        }

    }

    inner class WaitTask: AsyncTask<Void, Void, Unit>() {

        override fun doInBackground(vararg params: Void?): Unit {
            val start = System.currentTimeMillis()
            while (System.currentTimeMillis() - start < 5000);
        }

        override fun onPostExecute(result: Unit?) {
            super.onPostExecute(result)
            textView.text = "DONE"
        }
    }
}
