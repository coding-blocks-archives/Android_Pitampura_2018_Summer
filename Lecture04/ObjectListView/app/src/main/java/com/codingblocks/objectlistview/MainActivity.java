package com.codingblocks.objectlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

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
        String[] courseNames = {"Launchpad", "Crux", "Android", "Webdev", "ML"};
        String[] teachers = {"Prateek", "Deepak", "Garima", "Rishab", "Himank"};
        String[] centres = {"Pitampura", "Dwarka", "Noida", "Dehradun", "Online"};
        Random r = new Random();

        for (int i = 0; i < 300; i++) {
            courseList.add(new Course(
                    courseNames[r.nextInt(5)],
                    teachers[r.nextInt(5)],
                    centres[r.nextInt(5)],
                    30 + r.nextInt(20)
            ));
        }
    }
}
