package com.codingblocks.objectlistview;

public class Course {
    private String name;
    private String teacherName;
    private String centerName;
    private Integer capacity;

    public String getName() {
        return name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public String getCenterName() {
        return centerName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Course(String name, String teacherName, String centerName, Integer capacity) {
        this.name = name;
        this.teacherName = teacherName;
        this.centerName = centerName;
        this.capacity = capacity;
    }
}
