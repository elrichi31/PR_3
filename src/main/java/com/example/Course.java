//package com.example;

public class Course {
    private int facultyId;
    private String course;
    private int courseId;
    public Course(int facultyId, String course, int courseId) {
        this.facultyId = facultyId;
        this.course = course;
        this.courseId = courseId;
    }
    
    public int getFacultyId() {
        return facultyId;
    }
    
    public void setFacultyId(int id) {
        this.facultyId = id;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public int getCourseId() {
        return courseId;
    }
    
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    
}
