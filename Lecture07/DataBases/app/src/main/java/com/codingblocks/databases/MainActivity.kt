package com.codingblocks.databases

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.codingblocks.databases.adapters.TaskRecyclerAdapter
import com.codingblocks.databases.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tasks = ArrayList<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTasks.layoutManager = LinearLayoutManager(this)

        val taskAdapter = TaskRecyclerAdapter(tasks)
        rvTasks.adapter = taskAdapter

        btnAddTask.setOnClickListener {
            tasks.add(Task(
                    etNewTask.text.toString(),
                    false
            ))
            taskAdapter.notifyDataSetChanged()
        }

    }
}
