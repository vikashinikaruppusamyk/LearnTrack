package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.enums.EnrollmentStatus;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class EnrollmentService {
    private EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    public void enrollStudent(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(id, studentId, courseId, "2026-03-26", EnrollmentStatus.ACTIVE);
        enrollmentRepository.addEnrollment(enrollment);
    }
    public ArrayList<Enrollment> listEnrollments(){
        return enrollmentRepository.findAllEnrollments();
    }
    public ArrayList<Enrollment> findEnrollmentsByStudentId(int studentId) {
        ArrayList<Enrollment> enrollments = enrollmentRepository.findAllEnrollments();
        ArrayList<Enrollment> result = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudentId() == studentId) {
                result.add(enrollment);
            }
        }
        return result;
    }
    public void markAsCompleted(int id) {
        Enrollment enrollment = enrollmentRepository.findByEnrollmentId(id);
        enrollment.setStatus(EnrollmentStatus.COMPLETED);
    }
    public void cancelEnrollment (int id) {
        Enrollment enrollment = enrollmentRepository.findByEnrollmentId(id);
        enrollment.setStatus(EnrollmentStatus.CANCELLED);
    }
}
