package constructorsAndAccessSpecifiers;

class Student {
    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int rollNumber, String name, double cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public double getCgpa() {
        return this.cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    void displayDetails() {
        System.out.println("Roll Number: " + this.rollNumber);
        System.out.println("Name: " + this.name);
        System.out.println("CGPA: " + this.cgpa);
    }
}

class PostgraduateStudent extends Student {

    private String specialization;

    PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
        super(rollNumber, name, cgpa);
        this.specialization = specialization;
    }

    void displayPostgradDetails() {
        System.out.println("Postgraduate Student");
        System.out.println("Roll Number: " + this.rollNumber); // public
        System.out.println("Name: " + this.name);               // protected
        System.out.println("Specialization: " + this.specialization);
    }
}

public class UniversitySystem {

    public static void main(String[] args) {
        Student s1 = new Student(101, "Govind", 8.5);
        s1.displayDetails();
        System.out.println();

        s1.setCgpa(9.1);
        System.out.println("Updated CGPA: " + s1.getCgpa());
        System.out.println();

        PostgraduateStudent pg = new PostgraduateStudent(202, "Aryan", 8.9, "Data Science");
        pg.displayPostgradDetails();
    }
}
