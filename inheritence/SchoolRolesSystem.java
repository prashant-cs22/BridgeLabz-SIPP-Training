package inheritence;

class Person {
 protected String name;
 protected int age;

 Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 void displayBasicInfo() {
     System.out.println("Name: " + name);
     System.out.println("Age: " + age);
 }
}

class Teacher extends Person {
 private String subject;

 Teacher(String name, int age, String subject) {
     super(name, age);
     this.subject = subject;
 }

 void displayRole() {
     displayBasicInfo();
     System.out.println("Role: Teacher");
     System.out.println("Subject: " + subject);
 }
}

class Student extends Person {
 private int grade;

 Student(String name, int age, int grade) {
     super(name, age);
     this.grade = grade;
 }

 void displayRole() {
     displayBasicInfo();
     System.out.println("Role: Student");
     System.out.println("Grade: " + grade);
 }
}

class Staff extends Person {
 private String department;

 Staff(String name, int age, String department) {
     super(name, age);
     this.department = department;
 }

 void displayRole() {
     displayBasicInfo();
     System.out.println("Role: Staff");
     System.out.println("Department: " + department);
 }
}

public class SchoolRolesSystem {
 public static void main(String[] args) {
     Teacher t = new Teacher("Meena Sharma", 35, "Mathematics");
     Student s = new Student("Rahul Verma", 16, 10);
     Staff st = new Staff("Rakesh Kumar", 40, "Administration");

     System.out.println("--- Teacher Info ---");
     t.displayRole();

     System.out.println("\n--- Student Info ---");
     s.displayRole();

     System.out.println("\n--- Staff Info ---");
     st.displayRole();
 }
}
