package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
    TextView tvCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        tvCourse = findViewById(R.id.tvCourse);
        ArrayAdapter<String> courseAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                courses
        );
        lvCourses.setAdapter(courseAdapter);
        lvCourses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvCourse.setText(courses[position]);
            }
        });
    }
}
