package inheritence;

class Book {
	String title;
	int publicationYear;
	
	Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}
	
	void displayDetails() {
		System.out.println("Title: " + this.title);
		System.out.println("publicationYear: " + this.publicationYear);
	}
}

class Auther extends Book {
	String name;
	String bio;
	
	Auther(String name, String title, int publicationYear, String bio) {
		super(title, publicationYear);
		this.name = name;
		this.bio = bio;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Auther name: " + name);
		System.out.println("Auther bio: " + bio);
	}
}

public class LibraryManagement {

	public static void main(String[] args) {
		Book book = new Auther("Govind", "Nuclear Energy", 2025, "Software engineer from iit bombay");
		book.displayDetails();
	}

}
