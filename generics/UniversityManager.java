package generics;
import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    abstract String getEvaluationMethod();
}

class ExamBasedCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Final Exam";
    }
}

class AssignmentBasedCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Continuous Assignments";
    }
}

class ResearchBasedCourse extends CourseType {
    @Override
    String getEvaluationMethod() {
        return "Research Thesis";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T evaluationType;

    public Course(String courseName, T evaluationType) {
        this.courseName = courseName;
        this.evaluationType = evaluationType;
    }

    public String getCourseDetails() {
        return "Course: '" + courseName + "', Evaluation: " + evaluationType.getEvaluationMethod();
    }
}

public class UniversityManager {

    public static void displayAllCourses(List<Course<? extends CourseType>> courses) {
        System.out.println("\n--- University Course Roster ---");
        for (Course<?> course : courses) {
            System.out.println(course.getCourseDetails());
        }
        System.out.println("--------------------------------");
    }

    public static void main(String[] args) {
        Course<ExamBasedCourse> mathCourse = new Course<>("Calculus I", new ExamBasedCourse());
        Course<AssignmentBasedCourse> programmingCourse = new Course<>("Data Structures in Java", new AssignmentBasedCourse());
        Course<ResearchBasedCourse> physicsCourse = new Course<>("Quantum Mechanics Seminar", new ResearchBasedCourse());

        List<Course<? extends CourseType>> allCourses = new ArrayList<>();
        allCourses.add(mathCourse);
        allCourses.add(programmingCourse);
        allCourses.add(physicsCourse);
        
        System.out.println("Single Course Detail: " + programmingCourse.getCourseDetails());

        displayAllCourses(allCourses);
    }
}