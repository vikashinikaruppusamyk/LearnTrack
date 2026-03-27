package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.ArrayList;

public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public void addStudent(String firstName, String lastName, String email, String batch) {
        int id = IdGenerator.getNextStudentId();
        Student student = new Student(id, firstName, lastName, email, batch);
        studentRepository.addStudent(student);
    }
    public ArrayList<Student> listStudents(){
        return studentRepository.findAllStudent();
    }
    public Student findStudentById(int id){
        return studentRepository.findByStudentId(id);
    }
    public void removeStudent(int id){
        studentRepository.deleteByStudentId(id);
    }
    public void deactivateStudent(int id) {
        Student student = studentRepository.findByStudentId(id);
        student.setActive(false);
    }
    public void updateStudent(int id, String firstName, String lastName, String email, String batch) {
        Student student = studentRepository.findByStudentId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setBatch(batch);
    }
}
