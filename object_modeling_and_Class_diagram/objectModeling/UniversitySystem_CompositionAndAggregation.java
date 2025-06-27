package objectModeling;

import java.util.ArrayList;

class Department {
    String name;
    ArrayList<Faculty> faculties = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    void listFaculties() {
        System.out.println("Faculties in " + name + ":");
        for (Faculty f : faculties) {
            System.out.println("- " + f.name);
        }
    }
}

class Faculty {
    String name;

    Faculty(String name) {
        this.name = name;
    }
}

class University {
    String name;
    ArrayList<Department> departments = new ArrayList<>();

    University(String name) {
        this.name = name;
    }

    void addDepartment(Department department) {
        departments.add(department);
    }

    void deleteUniversity() {
        departments.clear(); // Composition: departments cease to exist
        System.out.println(name + " and all its departments have been deleted.");
    }

    void listDepartments() {
        System.out.println("Departments in " + name + ":");
        for (Department d : departments) {
            System.out.println("- " + d.name);
        }
    }
}

public class UniversitySystem_CompositionAndAggregation {
    public static void main(String[] args) {
        University uni = new University("Tech University");

        Department cs = new Department("Computer Science");
        Department ee = new Department("Electrical Engineering");

        Faculty profA = new Faculty("Prof. A");
        Faculty profB = new Faculty("Prof. B");

        cs.addFaculty(profA);
        ee.addFaculty(profB);

        uni.addDepartment(cs);
        uni.addDepartment(ee);

        uni.listDepartments();
        cs.listFaculties();
        ee.listFaculties();

        uni.deleteUniversity(); // Composition effect
    }
}
