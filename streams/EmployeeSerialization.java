package streams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        String fileName = "employees.ser";
        
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(101, "Alice", "Engineering", 95000));
        employeeList.add(new Employee(102, "Bob", "HR", 65000));
        employeeList.add(new Employee(103, "Charlie", "Marketing", 75000));
        
        // --- Serialization ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employeeList);
            System.out.println("✅ Employee list has been serialized to " + fileName);
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }
        
        System.out.println("\n--- Deserialization ---");
        
        // --- Deserialization ---
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Employee> retrievedList = (List<Employee>) ois.readObject();
            
            System.out.println("Retrieved employees from " + fileName + ":");
            for (Employee emp : retrievedList) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        }
    }
}
