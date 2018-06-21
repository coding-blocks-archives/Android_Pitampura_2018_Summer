package com.codingblocks.listviewkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_course.view.*

class CourseListAdapter (val courses: ArrayList<Course>) : BaseAdapter() {
    val TAG = "CLA"

    data class CourseViewHolder (
            val tvTeacherName: TextView,
            val tvCourseName: TextView,
            val tvCenterName: TextView,
            val tvCapacity: TextView
    )
    override fun getItem(position: Int): Course = courses[position]
    override fun getItemId(position: Int): Long = 0
    override fun getCount(): Int = courses.size

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        Log.d(TAG, "getView ${position} ${convertView}");
        var itemView = convertView

        parent?.let {
            val li = it.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            if (itemView == null) {
                itemView = li.inflate(R.layout.list_item_course, it, false)

                itemView!!.let {
                    it.tag = CourseViewHolder(
                            it.tvTeacherName,
                            it.tvCourseName,
                            it.tvCenterName,
                            it.tvCapacity
                    )
                }
            }
            val course = getItem(position)
            val courseViewHolder = itemView!!.tag as CourseViewHolder

            courseViewHolder.tvTeacherName.text = course.teacherName
            courseViewHolder.tvCourseName.text = course.name
            courseViewHolder.tvCenterName.text = course.centerName
            courseViewHolder.tvCapacity.text = course.capacity.toString()

            return itemView
        }
        return null
    }

}