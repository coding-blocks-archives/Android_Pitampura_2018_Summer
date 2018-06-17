package com.codingblocks.objectlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Course> courseList = new ArrayList<>();
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateCourses();

        lvCourses = findViewById(R.id.lvCourses);
        CourseListAdapter courseListAdapter = new CourseListAdapter(courseList);
        lvCourses.setAdapter(courseListAdapter);
    }

    void populateCourses() {
        courseList.add(new Course(
                "Launchpad",
                "Deepak",
                "Pitampura",
                30));
        courseList.add(new Course(
                "Crux",
                "Garima",
                "Pitampura",
                35));
        courseList.add(new Course(
                "Crux",
                "Rishab",
                "Dwarka",
                40));
    }
}
