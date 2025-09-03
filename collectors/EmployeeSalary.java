package collectors;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
	String department;
	double salary;
	
	Employee(String department, double salary) {
		this.department = department;
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}
}

public class EmployeeSalary {
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Engineering", 75000),
                new Employee("Sales", 60000),
                new Employee("Engineering", 90000),
                new Employee("Sales", 65000),
                new Employee("Marketing", 55000)
            );
        
        Map<String, Double> avgSalaryByDepartment = employees.stream()
        		.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        
        avgSalaryByDepartment.forEach((department, salary) -> {
        	System.out.println("Department: " + department + ", average salary: " + salary);
        });
	}
}
