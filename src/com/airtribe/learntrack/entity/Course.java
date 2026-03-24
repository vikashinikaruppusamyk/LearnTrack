package com.airtribe.learntrack.entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private boolean active;

    public Course(int id, String courseName,String description,int durationInWeeks,boolean active){
        this.id = id;
        this.courseName = courseName;
        this.durationInWeeks = durationInWeeks;
        this.active = active;
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
    public boolean isActive(){
        return active;
    }
    public void setActive(boolean active){
        this.active = active;
    }
}
