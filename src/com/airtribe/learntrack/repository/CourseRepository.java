package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;

import java.util.ArrayList;


public class CourseRepository {
    private static ArrayList<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }
    public ArrayList<Course> findAllCourses(){
        return courses;
    }
    public Course findByCourseId(int id){
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }
    public void deleteByCourseId(int id){
        for(Course course: courses){
            if(course.getId()==id){
                courses.remove(course);
                break;
            }
        }
    }
}
