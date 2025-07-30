package collection;

class GroupObjectsByProperty {
	private String name;
	private String department;

	public GroupObjectsByProperty(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class GroupObjectsByProperty {
	public static void main(String[] args) {
		List<Employee> employees = List.of(new Employee("Alice", "HR"), new Employee("Bob", "IT"),
				new Employee("Carol", "HR"));

		Map<String, List<Employee>> employeesByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println("Employees: [Alice (HR), Bob (IT), Carol (HR)]");
		System.out.println("Output:");
		employeesByDept.forEach((dept, empList) -> System.out.println(dept + ": " + empList));
	}
}
