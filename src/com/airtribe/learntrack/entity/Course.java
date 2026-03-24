package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    public Course(int id, String courseName,String description,int durationInWeeks,CourseStatus status){
        this.id = id;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.status = status;
        this.description = description;
    }
    public Course(){

    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getDurationInWeeks(){
        return durationInWeeks;
    }
    public void setDurationInWeeks(int durationInWeeks){
        this.durationInWeeks = durationInWeeks;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public CourseStatus getStatus(){
        return status;
    }
    public void setStatus(CourseStatus status){
        this.status = status;
    }
}
