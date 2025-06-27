package objectModeling;

import java.util.*;
class Book {
	String author;
	String title;
	
	Book(String author, String title) {
		this.author = author;
		this.title = title;
	}
	
	void displayBook() {
		System.out.println("Book title: " + title);
		System.out.println("Book author: " + author);
	}
}

class Library {
	String name;
	ArrayList<Book> books = new ArrayList<>();
	
	Library(String name) {
		this.name = name;
	}
	
	void addBook(Book book) {
		books.add(book);
	}
	
	void displayLibrary() {
		System.out.println("Library name: " + name);
		System.out.println("Books in the library :- ");
		for(Book book: books) {
			System.out.println(book.title + " by " + book.author);
		}
		System.out.println();
	}
}

public class Library_Aggregation {

	public static void main(String[] args) {
		Book b1 = new Book("Govind", "What is life");
		Book b2 = new Book("Gopal", "What is beyond life");
		
		Library l1 = new Library("library 1");
		l1.addBook(b1);
		l1.addBook(b2);
		
		Library l2 = new Library("library 2");
		l2.addBook(b2);
		
		l1.displayLibrary();
		l2.displayLibrary();
	}

}
