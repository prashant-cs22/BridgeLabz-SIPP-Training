package inheritence;

class Employee {
	String name;
	int id;
	double salary;
	
	Employee(String name, int id, double salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	
	void displayDetails() {
		System.out.println("Name: " + this.name);
		System.out.println("id: " + this.id);
		System.out.println("salary: " + this.salary);
	}
}

class Manager extends Employee {
	int teamSize;
	
	Manager(String name, int id, double salary, int teamSize) {
		super(name, id, salary);
		this.teamSize = teamSize;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Role: Manager");
		System.out.println("Team size: " + teamSize);
	}
}

class Developer extends Employee {
	String programmingLanguage;
	
	Developer(String name, int id, double salary, String programmingLanguage){
		super(name, id, salary);
		this.programmingLanguage = programmingLanguage;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Role: Employee");
		System.out.println("programmingLanguage: " + programmingLanguage);
	}
}

class Intern extends Employee {
	String mentor;
	
	Intern(String name, int id, double salary, String mentor) {
		super(name, id, salary);
		this.mentor = mentor;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Role: Employee");
		System.out.println("mentor: " + mentor);
	}
	
}

public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee manager = new Manager("Kunal", 1, 50000, 5);
		Employee developer = new Developer("Govind", 2, 50000, "Java");
		Employee intern = new Intern("Luvya", 3, 50000, "Mr. Praveen");
		
		manager.displayDetails();
		developer.displayDetails();
		intern.displayDetails();
	}
}
