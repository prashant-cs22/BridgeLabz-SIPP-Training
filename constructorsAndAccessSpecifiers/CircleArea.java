package constructorsAndAccessSpecifiers;

class Circle {
    private double radius;

    Circle() {
        this(1.0); // Default radius
    }

    Circle(double radius) {
        this.radius = radius;
    }

    void displayDetails() {
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + findArea());
    }

    double findArea() {
        return Math.PI * radius * radius;
    }
}

public class CircleArea {

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(3.5);

        System.out.println("Default Circle - ");
        defaultCircle.displayDetails();
        System.out.println();

        System.out.println("Custom Circle - ");
        customCircle.displayDetails();
    }
}
