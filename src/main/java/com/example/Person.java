package com.example;

public class Person {
    private int faculty_id;//id
    private String course;//firstName
    private String course_id;//lastName
    //private String email;
    public Person(int faculty_id, String course, String course_id) {
        this.faculty_id = faculty_id;
        this.course = course;
        this.course_id = course_id;
    }
    
    public int getFacultyId() {
        return faculty_id;
    }
    
    public void setFacultyId(int id) {
        this.faculty_id = faculty_id;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getCourseId() {
        return course_id;
    }
    
    public void setCourseId(String course_id) {
        this.course_id = course_id;
    }
    
}
