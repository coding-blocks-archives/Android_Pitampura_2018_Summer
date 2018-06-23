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

    override fun onCreateViewHolder(
            parent: ViewGroup, viewType: Int
    ) = CourseViewHolder(
            (parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                    .inflate(R.layout.list_item_course, parent, false)
    )



    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) = holder.bindData(courses[position])

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teacherName = itemView.tvTeacherName
        val courseName = itemView.tvCourseName
        val centerName = itemView.tvCenterName
        val capacity = itemView.tvCapacity

        fun bindData (course: Course) {
            teacherName.text = course.teacherName
            courseName.text = course.name
            centerName.text = course.centerName
            capacity.text = course.capacity.toString()
        }
    }

}


