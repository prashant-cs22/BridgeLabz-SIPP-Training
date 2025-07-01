package inheritence;

interface Worker {
 void performDuties();
}

class Person {
 protected String name;
 protected int id;

 Person(String name, int id) {
     this.name = name;
     this.id = id;
 }

 void displayBasicInfo() {
     System.out.println("Name: " + name);
     System.out.println("ID: " + id);
 }
}

class Chef extends Person implements Worker {
 private String specialty;

 Chef(String name, int id, String specialty) {
     super(name, id);
     this.specialty = specialty;
 }

 @Override
 public void performDuties() {
     System.out.println(name + " is preparing " + specialty + " dishes.");
 }

 void displayRole() {
     displayBasicInfo();
     System.out.println("Role: Chef");
     System.out.println("Specialty: " + specialty);
 }
}

class Waiter extends Person implements Worker {
 private int tablesAssigned;

 Waiter(String name, int id, int tablesAssigned) {
     super(name, id);
     this.tablesAssigned = tablesAssigned;
 }

 @Override
 public void performDuties() {
     System.out.println(name + " is serving " + tablesAssigned + " tables.");
 }

 void displayRole() {
     displayBasicInfo();
     System.out.println("Role: Waiter");
     System.out.println("Tables Assigned: " + tablesAssigned);
 }
}

public class RestaurantStaffSystem {
 public static void main(String[] args) {
     Worker chef = new Chef("Aarti", 501, "Italian");
     Worker waiter = new Waiter("Sunil", 502, 6);

     System.out.println("--- Chef Details ---");
     ((Chef) chef).displayRole();
     chef.performDuties();

     System.out.println("\n--- Waiter Details ---");
     ((Waiter) waiter).displayRole();
     waiter.performDuties();
 }
}
