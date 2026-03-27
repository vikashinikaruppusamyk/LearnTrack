package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.enums.CourseStatus;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class CourseService {
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }
    public void addCourse(String courseName, String description, int durationInWeeks) {
        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, courseName, description, durationInWeeks, CourseStatus.ACTIVE);
        courseRepository.addCourse(course);
    }
    public ArrayList<Course> listCourses(){
        return courseRepository.findAllCourses();
    }
    public Course findCourseById(int id){
        return courseRepository.findByCourseId(id);
    }
    public void removeCourse(int id){
        courseRepository.deleteByCourseId(id);
    }
    public void activateCourse(int id) {
        Course course = courseRepository.findByCourseId(id);
        course.setStatus(CourseStatus.ACTIVE);
    }
    public void deactivateCourse(int id) {
        Course course = courseRepository.findByCourseId(id);
        course.setStatus(CourseStatus.INACTIVE);
    }
}
