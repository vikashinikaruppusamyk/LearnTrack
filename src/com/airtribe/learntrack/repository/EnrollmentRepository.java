package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.service.EnrollmentService;

import java.util.ArrayList;

public class EnrollmentRepository {
    private static ArrayList<Enrollment> enrollments = new ArrayList<>();

    public void addEnrollment(Enrollment enrollment){
        enrollments.add(enrollment);
    }
    public ArrayList<Enrollment> findAllEnrollments(){
        return enrollments;
    }
    public Enrollment findByEnrollmentId(int id){
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }
    public void deleteByEnrollmentId(int id){
        for(Enrollment enrollment: enrollments){
            if(enrollment.getId()==id){
                enrollments.remove(enrollment);
                break;
            }
        }
    }
}
