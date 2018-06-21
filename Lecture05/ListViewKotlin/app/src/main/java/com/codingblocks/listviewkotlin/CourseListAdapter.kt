package com.codingblocks.listviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_course.view.*

class CourseListAdapter (val courses: ArrayList<Course>) : BaseAdapter() {

    override fun getItem(position: Int): Course = courses[position]
    override fun getItemId(position: Int): Long = 0
    override fun getCount(): Int = courses.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        parent?.let {
            val li = it.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemView = li.inflate(R.layout.list_item_course, it, false)
            val course = getItem(position)

            itemView.tvTeacherName.text = course.teacherName
            itemView.tvCourseName.text = course.name
            itemView.tvCenterName.text = course.centerName
            itemView.tvCapacity.text = course.capacity.toString()

            return itemView
        }
        return null
    }

}