package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Student;

import java.util.ArrayList;

public class StudentRepository {
    private static ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        students.add(student);
    }
    public ArrayList<Student> findAllStudent(){
        return students;
    }
    public Student findByStudentId(int id){
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public void deleteByStudentId(int id){
        for(Student student: students){
            if(student.getId()==id){
                students.remove(student);
                break;
            }
        }
    }
}
