package com.codingblocks.databases.db.tables

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.codingblocks.databases.models.Task

class TaskTable {
    companion object {
        val TABLE_NAME = "tasks"
        val CMD_CREATE_TABLE = """
            CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (
                ${Columns.ID} INTEGER AUTO_INCREMENT PRIMARY KEY,
                ${Columns.TASK} TEXT,
                ${Columns.DONE} BOOLEAN
            );
        """.trimIndent()

        fun addTask(db: SQLiteDatabase, task: Task): Long {
            val row = ContentValues()
            row.put(Columns.TASK, task.taskName)
            row.put(Columns.DONE, task.done)
            return db.insert(TABLE_NAME, null, row)
        }
        fun getAllTasks(db: SQLiteDatabase): ArrayList<Task> {
            val tasks = ArrayList<Task>()
            val cursor = db.query(
                    TABLE_NAME,
                    arrayOf(Columns.ID, Columns.TASK, Columns.DONE),
                    null, null,
                    null, null,
                    null
            )
            val idCol = cursor.getColumnIndex(Columns.ID)
            val taskCol = cursor.getColumnIndex(Columns.TASK)
            val donCol = cursor.getColumnIndex(Columns.DONE)

            while (cursor.moveToNext()) {
                val rowTask = Task(
                        cursor.getInt(idCol),
                        cursor.getString(taskCol),
                        cursor.getInt(donCol) == 1
                )
                tasks.add(rowTask)
            }

            return tasks
        }
    }

    object Columns {
        val ID = "id"
        val TASK = "task"
        val DONE = "done"
    }
}