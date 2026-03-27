package com.airtribe.learntrack;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.service.CourseService;
import com.airtribe.learntrack.service.EnrollmentService;
import com.airtribe.learntrack.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        StudentRepository studentRepository = new StudentRepository();
        CourseRepository courseRepository = new CourseRepository();
        EnrollmentRepository enrollmentRepository = new EnrollmentRepository();
        StudentService studentService = new StudentService(studentRepository);
        CourseService courseService = new CourseService(courseRepository);
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("=== LearnTrack ===");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    showStudentMenu(scanner, studentService);
                    break;
                case 2:
                    showCourseMenu(scanner, courseService);
                    break;
                case 3:
                    showEnrollmentMenu(scanner, enrollmentService);
                    break;
                case 0:
                    System.out.println("Exiting LearnTrack. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
    private static void showStudentMenu(Scanner scanner, StudentService studentService) {
        while(true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Deactivate Student");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.println("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter email: ");
                    String email = scanner.nextLine();
                    System.out.println("Enter batch: ");
                    String batch = scanner.nextLine();
                    studentService.addStudent(firstName, lastName, email, batch);
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    ArrayList<Student> students = studentService.listStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student student : students) {
                            System.out.println(student.getId() + " - " + student.getDisplayName() + " - " + student.getBatch());
                        }
                    }
                    break;
                case 3:{
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    Student student = studentService.findStudentById(id);
                    if (student == null) {
                        System.out.println("Student not found!");
                    } else {
                        System.out.println(student.getId() + " - " + student.getDisplayName() + " - " + student.getBatch());
                    }
                    break;}
                case 4:{
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    studentService.deactivateStudent(id);
                    System.out.println("Student deactivated successfully.");
                    break;}
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void showCourseMenu(Scanner scanner, CourseService courseService) {
        while(true) {
            System.out.println("\n=== Course Menu ===");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Activate Course");
            System.out.println("4. Deactivate Course");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    System.out.print("Enter Course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Duration in weeks: ");
                    int durationInWeeks = scanner.nextInt();
                    courseService.addCourse(courseName,description,durationInWeeks);
                    System.out.println("Course added successfully!");
                    break;
                case 2:
                    ArrayList<Course> courses = courseService.listCourses();
                    if (courses.isEmpty()) {
                        System.out.println("No courses found.");
                    } else {
                        for (Course course : courses) {
                            System.out.println(course.getId() + " - " + course.getCourseName() + " - " + course.getStatus());
                        }
                    }
                    break;
                case 3:{
                    System.out.print("Enter course ID: ");
                    int id = scanner.nextInt();
                    courseService.activateCourse(id);
                    System.out.println("Course activated successfully!");
                    break;}
                case 4:{
                    System.out.print("Enter course ID: ");
                    int id = scanner.nextInt();
                    courseService.deactivateCourse(id);
                    System.out.println("Course deactivated successfully!");
                    break;}
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void showEnrollmentMenu(Scanner scanner, EnrollmentService enrollmentService) {
        while(true) {
            System.out.println("\n=== Enrollment Menu ===");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollments by Student ID");
            System.out.println("3. Mark Enrollment as Completed");
            System.out.println("4. Cancel Enrollment");
            System.out.println("0. Back");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1: {
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseId = scanner.nextInt();
                    enrollmentService.enrollStudent(studentId, courseId);
                    System.out.println("Student enrolled successfully!");
                    break;
                }
                case 2: {
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    ArrayList<Enrollment> enrollments = enrollmentService.findEnrollmentsByStudentId(studentId);
                    if (enrollments.isEmpty()) {
                        System.out.println("No enrollments found.");
                    } else {
                        for (Enrollment enrollment : enrollments) {
                            System.out.println(enrollment.getId() + " - Course ID: " + enrollment.getCourseId() + " - Status: " + enrollment.getStatus());
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.print("Enter enrollment ID: ");
                    int id = scanner.nextInt();
                    enrollmentService.markAsCompleted(id);
                    System.out.println("Enrollment is completed successfully!");
                    break;}
                case 4:{
                    System.out.print("Enter enrollment ID: ");
                    int id = scanner.nextInt();
                    enrollmentService.cancelEnrollment(id);
                    System.out.println("Enrollment is cancelled successfully!");
                    break;}
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}