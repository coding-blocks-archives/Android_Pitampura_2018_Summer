package com.codingblocks.kotlinrecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_course.view.*

class CourseAdapter (
        val courses: ArrayList<Course>
): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    override fun getItemCount(): Int = courses.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val li = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = li.inflate(R.layout.list_item_course, parent, false)
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courses[position]
        holder.teacherName?.text = course.teacherName
        holder.courseName?.text = course.name
        holder.centerName?.text = course.centerName
        holder.capacity?.text = course.capacity.toString()
    }

    class CourseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val teacherName = itemView?.tvTeacherName
        val courseName = itemView?.tvCourseName
        val centerName = itemView?.tvCenterName
        val capacity = itemView?.tvCapacity
    }

}


