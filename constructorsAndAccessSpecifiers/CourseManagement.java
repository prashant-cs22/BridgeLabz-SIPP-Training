package constructorsAndAccessSpecifiers;

class Course {
    private String courseName;
    private int duration; // in months
    private double fee;
    private static String instituteName = "ABC Institute";

    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Course Name: " + this.courseName);
        System.out.println("Duration: " + this.duration + " months");
        System.out.println("Fee: ₹" + this.fee);
        System.out.println("Institute: " + instituteName);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }
}

public class CourseManagement {

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3, 5000);
        Course c2 = new Course("Web Development", 4, 7000);

        System.out.println("Course 1 - ");
        c1.displayCourseDetails();
        System.out.println();

        System.out.println("Course 2 - ");
        c2.displayCourseDetails();
        System.out.println();

        Course.updateInstituteName("SkillSharp Academy");
        System.out.println("After Updating Institute Name - ");
        c1.displayCourseDetails();
    }
}
