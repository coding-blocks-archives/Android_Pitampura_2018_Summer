package com.codingblocks.databases

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.codingblocks.databases.adapters.TaskRecyclerAdapter
import com.codingblocks.databases.db.TodoDbHelper
import com.codingblocks.databases.db.tables.TaskTable
import com.codingblocks.databases.models.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tasks = ArrayList<Task>()
    lateinit var taskAdapter: TaskRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = TodoDbHelper(this).writableDatabase

        rvTasks.layoutManager = LinearLayoutManager(this)
        fun refreshTodos () {
            tasks.clear()
            tasks.addAll(TaskTable.getAllTasks(db))
            taskAdapter.notifyDataSetChanged()
        }

        val onTaskUpdate = {
            task: Task ->
            TaskTable.updateTask(db, task)
            refreshTodos()
        }
        val onTaskDelete = {
            task: Task ->
            TaskTable.deleteTask(db, task)
            refreshTodos()
        }

        taskAdapter = TaskRecyclerAdapter(tasks, onTaskUpdate, onTaskDelete)
        rvTasks.adapter = taskAdapter

        refreshTodos()


        btnAddTask.setOnClickListener {
            val newTask = Task(
                    null,
                    etNewTask.text.toString(),
                    false
            )
            val id = TaskTable.addTask(db, newTask)
            refreshTodos()
            Log.d("TASK", "INSERTED AT ${id}")
            taskAdapter.notifyDataSetChanged()
        }

        btnClearTask.setOnClickListener {
            TaskTable.deleteTask(db, true)
            refreshTodos()
        }

    }
}
