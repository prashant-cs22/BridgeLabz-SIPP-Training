package classesAndObjects;

class Student {
	int rollNo;
	String name;
	int marks;
	char grade;
	
	Student(int rollNo, String name, int marks) {
		this.rollNo = rollNo;
		this.name = name;
		this.marks = marks;
	}
	
	char findGrade(int marks) {
		char grade;
		switch (marks / 10) {
        case 10: 
        	grade = 'O';
        	break;
        case 9:
            grade = 'A';
            break;
        case 8:
            grade = 'B';
            break;
        case 7:
            grade = 'C';
            break;
        case 6:
            grade = 'D';
            break;
        case 5:
            grade = 'E';
            break;
        default:
            grade = 'F';
		}
		return grade;
	}
	
	void displayDetails() {
		System.out.println("Roll no.: " + this.rollNo);
		System.out.println("Name: " + this.name);
		System.out.println("Marks: " + this.marks);
		this.grade = findGrade(this.marks);
		System.out.println("Grade: " + this.grade);
	}
	
}

public class StudentReport {

	public static void main(String[] args) {
		Student student1 = new Student(1, "Govind", 70);
		Student student2 = new Student(2, "Goapl", 60);
		
		student1.displayDetails();
		student2.displayDetails();
	}

}
