package this_Static_Final_And_InstanceOf_Keywords;

class Student {
    static String universityName = "Tech University";
    private static int totalStudents = 0;

    private final int rollNumber;
    private String name;
    private String grade;

    public Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("Roll No: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
        }
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Student s1 = new Student(301, "Neha", "A");
        Student s2 = new Student(302, "Amit", "B");

        s1.displayStudentDetails();
        System.out.println();
        s2.displayStudentDetails();
        System.out.println();

        Student.displayTotalStudents();
    }
}
