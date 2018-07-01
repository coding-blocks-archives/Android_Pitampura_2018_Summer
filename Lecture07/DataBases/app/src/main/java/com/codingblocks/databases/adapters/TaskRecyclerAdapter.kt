package com.codingblocks.databases.adapters

import android.content.Context
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.codingblocks.databases.R
import com.codingblocks.databases.db.tables.TaskTable

import com.codingblocks.databases.models.Task
import kotlinx.android.synthetic.main.list_item_task.view.*

class TaskRecyclerAdapter (
        val tasks: ArrayList<Task>,
        val onTaskUpdate: (task: Task) -> Unit,
        val onTaskDelete: (task: Task) -> Unit
): RecyclerView.Adapter<TaskRecyclerAdapter.TaskViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.checkBox.setOnCheckedChangeListener(null)

        holder.itemView.checkBox.isChecked = tasks[position].done
        holder.itemView.tvTaskName.text = tasks[position].taskName

        holder.itemView.checkBox.setOnCheckedChangeListener {
            _, isChecked ->
            tasks[position].done = isChecked
            onTaskUpdate(tasks[position])
        }
        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context)
                    .setTitle("Delete Task")
                    .setMessage("Do you really want to delete this task ? ")
                    .setPositiveButton(
                            "YES",
                            { _, _ -> onTaskDelete(tasks[position]) }
                    )
                    .setNegativeButton("NO", {_, _ -> Unit})
                    .show()
            true
        }
    }

    class TaskViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}