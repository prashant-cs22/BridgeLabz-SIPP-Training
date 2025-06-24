package classesAndObjects;

class Employee {
	int id;
	String name;
	double salary;
	
	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	void displayDetails() {		
		System.out.println("id: " + this.id);
		System.out.println("Name: " + this.name);
		System.out.println("salary: " + this.salary);
	}
}

public class DisplayEmployeeDetails {

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Govind", 2000);
		Employee employee2 = new Employee(2, "Gopal", 4000);
		
		System.out.println("Employee 1- ");
		employee1.displayDetails();
		System.out.println("Employee 2- ");
		employee2.displayDetails();
	}

}
