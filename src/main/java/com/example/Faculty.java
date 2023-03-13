//package com.example;

public class Faculty {
    private int facultyId;
    private String facultyName;
    private String office;
    public Faculty(int facultyId, String facultyName, String office){
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.office = office;
    }
    public int getFacultyId() {
        return facultyId;
    }
    
    public void setFacultyId(int id) {
        this.facultyId = id;
    }

    public String getFacultyName (){
        return facultyName;
    }

    public void setFacultyName(String facultyName){
        this.facultyName = facultyName;
    }
    
    public String getOffice(){
        return office;
    }

    public void setOffice(String office){
        this.office = office;
    }

}
