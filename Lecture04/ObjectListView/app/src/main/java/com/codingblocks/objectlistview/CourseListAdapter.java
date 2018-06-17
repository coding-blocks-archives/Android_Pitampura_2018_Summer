package com.codingblocks.objectlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {
    private ArrayList<Course> courses;
    public CourseListAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }
    @Override
    public int getCount() {
        return courses.size();
    }

    @Override
    public Course getItem(int position) {
        return courses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater li = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_course, parent, false);
        Course course = getItem(position);

        TextView tvCourseName = itemView.findViewById(R.id.tvCourseName);
        TextView tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
        TextView tvCenterName = itemView.findViewById(R.id.tvCenterName);
        TextView tvCapacity = itemView.findViewById(R.id.tvCapacity);

        tvCourseName.setText(course.getName());
        tvTeacherName.setText(course.getTeacherName());
        tvCenterName.setText(course.getCenterName());
        tvCapacity.setText(String.valueOf(course.getCapacity()));

        return itemView;
    }
}
