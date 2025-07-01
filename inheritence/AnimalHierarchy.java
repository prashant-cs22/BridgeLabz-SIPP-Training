package inheritence;

class Animal {
	String name;
	int age;
	
	Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	void makeSound() {
		System.out.println(name + " makes some sound.");
	}
}

class Dog extends Animal {
	
	Dog(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println(name + " barks");
	}
}

class Cat extends Animal {
	
	Cat(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println(name + " meows");
	}
}

class Bird extends Animal {
	
	Bird(String name, int age) {
		super(name, age);
	}
	
	@Override
	void makeSound() {
		System.out.println(name + " tweets");
	}
}

public class AnimalHierarchy {

	public static void main(String[] args) {
		Animal dog = new Dog("Sheru", 5);
		dog.makeSound();
		
		Animal cat = new Cat("ChickPea", 2);
		cat.makeSound();
		
		Animal bird = new Bird("ChickPea", 2);
		bird.makeSound();
	}

}
