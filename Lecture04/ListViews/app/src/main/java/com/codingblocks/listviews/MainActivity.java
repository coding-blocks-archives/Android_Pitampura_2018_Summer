package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String[] courses = new String[] {
            "Launchpad", "Crux", "Webdev NodeJS",
            "Android", "Django", "Machine Learning",
            "Competitive Coding", "Java for Beginners",
            "C++ for Beginners", "Algo++", "Algo.Java",
            "Web Development with Java", "Angular", "React",
            "Flutter", "iOS"
    };
    ListView lvCourses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses
        );
        lvCourses.setAdapter(courseAdapter);
    }
}
