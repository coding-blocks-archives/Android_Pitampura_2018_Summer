package com.codingblocks.kotlinrecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCourses.layoutManager = GridLayoutManager(
                this, 5,
                RecyclerView.HORIZONTAL,
                false
        )
        rvCourses.adapter = CourseAdapter(genRandomCourses(200))
    }
}
