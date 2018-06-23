package com.codingblocks.kotlinrecyclerview

import java.util.*

data class Course (
        val name: String,
        val teacherName: String,
        val centerName: String,
        val capacity: Int
)
val courseNames = arrayOf("Crux", "Launchpad", "Android", "Nodejs")
val teachers = arrayOf("Harshit", "Aayush", "Anuj", "Rishab")
val centers = arrayOf("Pitampura", "Noida", "Dwarka", "Dehradun")

fun genRandomCourses (num: Int): ArrayList<Course> {
    val courses = ArrayList<Course>(num)
    val r = Random()
    for (i in 1..num) {
        courses.add(Course(
                courseNames[r.nextInt(4)],
                teachers[r.nextInt(4)],
                centers[r.nextInt(4)],
                30 + r.nextInt(20)
        ))
    }
    return courses
}