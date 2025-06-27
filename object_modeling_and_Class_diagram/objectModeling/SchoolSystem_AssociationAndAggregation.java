package objectModeling;

import java.util.ArrayList;

class Course {
    String courseName;
    ArrayList<Student> enrolledStudents = new ArrayList<>();

    Course(String courseName) {
        this.courseName = courseName;
    }

    void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    void displayEnrolledStudents() {
        System.out.println("Course: " + courseName);
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enroll(Course course) {
        courses.add(course);
        course.enrollStudent(this); // bidirectional association
    }

    void viewCourses() {
        System.out.println("Courses for " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

class School {
    String name;
    ArrayList<Student> students = new ArrayList<>();

    School(String name) {
        this.name = name;
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void listStudents() {
        System.out.println("Students at " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

public class SchoolSystem_AssociationAndAggregation {
    public static void main(String[] args) {
        School school = new School("Springfield High");

        Student s1 = new Student("Lisa");
        Student s2 = new Student("Bart");

        Course math = new Course("Mathematics");
        Course art = new Course("Art");

        s1.enroll(math);
        s1.enroll(art);
        s2.enroll(art);

        school.addStudent(s1);
        school.addStudent(s2);

        school.listStudents();

        s1.viewCourses();
        s2.viewCourses();

        math.displayEnrolledStudents();
        art.displayEnrolledStudents();
    }
}

