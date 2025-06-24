package constructorsAndAccessSpecifiers;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    void displayDetails() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }
}

public class PersonClone {

    public static void main(String[] args) {
        Person original = new Person("Govind", 25);
        Person clone = new Person(original);

        System.out.println("Original Person - ");
        original.displayDetails();
        System.out.println();

        System.out.println("Cloned Person - ");
        clone.displayDetails();
    }
}
