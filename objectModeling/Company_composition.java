package objectModeling;

import java.util.ArrayList;

class Company {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    Company(String name) {
        this.name = name;
    }

    void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    void deleteCompany() {
        departments.clear(); // Composition effect
        System.out.println(name + " and all departments have been deleted.");
    }

    class Department {
        String deptName;
        ArrayList<Employee> employees = new ArrayList<>();

        Department(String deptName) {
            this.deptName = deptName;
        }

        void addEmployee(String empName) {
            employees.add(new Employee(empName));
        }

        class Employee {
            String name;

            Employee(String name) {
                this.name = name;
            }
        }
    }
}

public class Company_composition {
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");
        techCorp.addDepartment("R&D");
        techCorp.departments.get(0).addEmployee("Asha");

        techCorp.deleteCompany(); // Destroys everything beneath
    }
}
