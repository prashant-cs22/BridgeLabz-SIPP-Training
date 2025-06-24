package constructorsAndAccessSpecifiers;

class Employee {
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    public void updateSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        }
    }

    public double getSalary() {
        return this.salary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + this.employeeID);
        System.out.println("Department: " + this.department);
        System.out.println("Salary: ₹" + this.salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    Manager(int employeeID, String department, double salary, int teamSize) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
    }

    void displayManagerDetails() {
        System.out.println("Manager Details");
        System.out.println("Employee ID: " + this.employeeID);   // public
        System.out.println("Department: " + this.department);    // protected
        System.out.println("Team Size: " + this.teamSize);
    }
}

public class EmployeeRecords {

    public static void main(String[] args) {
        Employee emp = new Employee(1001, "Engineering", 65000);
        emp.displayEmployeeDetails();
        System.out.println();

        emp.updateSalary(70000);
        System.out.println("Updated Salary: ₹" + emp.getSalary());
        System.out.println();

        Manager mgr = new Manager(2001, "Operations", 85000, 12);
        mgr.displayManagerDetails();
    }
}
