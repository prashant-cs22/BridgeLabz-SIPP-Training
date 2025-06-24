package classesAndObjects;

class Circle {
	float radius;
	float area;
	float circumference;
	
	Circle(float radius) {
		this.radius = radius;
	}
	
	void findArea(float radius) {
		float area = (float)Math.PI * radius * radius;
		this.area = area;
	}
	
	void findCircumference(float radius) {
		float circumference = 2 * (float)Math.PI * radius;
		this.circumference = circumference;
	}
	
	void displayDetails() {
		this.findArea(this.radius);
		this.findCircumference(this.radius);
		System.out.println("Area of the circle is: " + this.area);
		System.out.println("circumference of the circle is: " + this.circumference);
	}
}

public class AreaOfCircle {

	public static void main(String[] args) {
		Circle circle1 = new Circle(1);
		Circle circle2 = new Circle(2);
		
		System.out.println("Circle 1-");
		circle1.displayDetails();
		System.out.println("Circle 2-");
		circle2.displayDetails();
	}

}
