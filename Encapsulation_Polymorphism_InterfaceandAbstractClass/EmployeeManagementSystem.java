package Encapsulation_Polymorphism_InterfaceandAbstractClass;

abstract class Employee {
	private int employeeId;
	private String name;
	private double baseSalary;

	public Employee(int employeeId, String name, double baseSalary) {
		this.employeeId = employeeId;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getName() {
		return name;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		if (baseSalary >= 0) {
			this.baseSalary = baseSalary;
		}
	}

	public abstract double calculateSalary();

	public void displayDetails() {
		System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: ₹" + calculateSalary());
	}
}

class FullTimeEmployee extends Employee {
	public FullTimeEmployee(int id, String name, double baseSalary) {
		super(id, name, baseSalary);
	}

	@Override
	public double calculateSalary() {
		return getBaseSalary(); // Fixed salary
	}
}

class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
		super(id, name, 0); // baseSalary not used for part-time
		this.hourlyRate = hourlyRate;
		this.hoursWorked = hoursWorked;
	}

	@Override
	public double calculateSalary() {
		return hourlyRate * hoursWorked;
	}
}

interface Department {
	void assignDepartment(String dept);

	String getDepartmentDetails();
}

class HRDepartment implements Department {
	private String departmentName;

	@Override
	public void assignDepartment(String dept) {
		this.departmentName = dept;
	}

	@Override
	public String getDepartmentDetails() {
		return "Department: " + departmentName;
	}
}


public class EmployeeManagementSystem {
	public static void main(String[] args) {
		Employee e1 = new FullTimeEmployee(101, "Aman", 50000);
		Employee e2 = new PartTimeEmployee(102, "Neha", 400, 60);

		e1.displayDetails();
		e2.displayDetails();

		Department dept = new HRDepartment();
		dept.assignDepartment("Human Resources");
		System.out.println(dept.getDepartmentDetails());
	}
}
