package objectModeling;

import java.util.ArrayList;

class Course {
    String name;
    ArrayList<Student> students = new ArrayList<>();
    Professor professor;

    Course(String name) {
        this.name = name;
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
    }

    void enrollStudent(Student student) {
        students.add(student);
    }

    void listStudents() {
        System.out.println("Students enrolled in " + name + ":");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }

    void showProfessor() {
        if (professor != null) {
            System.out.println("Professor for " + name + ": " + professor.name);
        } else {
            System.out.println("No professor assigned to " + name);
        }
    }
}

class Student {
    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void enrollCourse(Course course) {
        courses.add(course);
        course.enrollStudent(this);
    }

    void listCourses() {
        System.out.println("Courses for " + name + ":");
        for (Course c : courses) {
            System.out.println("- " + c.name);
        }
    }
}

class Professor {
    String name;

    Professor(String name) {
        this.name = name;
    }
}

public class UniversityManagement_AssociationAndAggregation {
    public static void main(String[] args) {
        Student s1 = new Student("Lisa");
        Student s2 = new Student("Bart");

        Professor profA = new Professor("Prof. A");
        Professor profB = new Professor("Prof. B");

        Course math = new Course("Mathematics");
        Course art = new Course("Art");

        math.assignProfessor(profA);
        art.assignProfessor(profB);

        s1.enrollCourse(math);
        s1.enrollCourse(art);
        s2.enrollCourse(art);

        math.showProfessor();
        art.showProfessor();

        math.listStudents();
        art.listStudents();

        s1.listCourses();
        s2.listCourses();
    }
}
