package this_Static_Final_And_InstanceOf_Keywords;

class Employee {
    static String companyName = "CodeCraft Corp";
    private static int totalEmployees = 0;

    private final int id;
    private String name;
    private String designation;

    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    public void displayDetails() {
        if (this instanceof Employee) {
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
            System.out.println("Company: " + companyName);
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Ravi", "Developer");
        Employee e2 = new Employee(102, "Meena", "Designer");

        e1.displayDetails();
        System.out.println();
        e2.displayDetails();
        System.out.println();

        Employee.displayTotalEmployees();
    }
}
