package Encapsulation_Polymorphism_InterfaceandAbstractClass;

abstract class LibraryItem {
	private int itemId;
	private String title;
	private String author;

	public LibraryItem(int itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
	}

	public int getItemId() {
		return itemId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public abstract int getLoanDuration(); // in days

	public void getItemDetails() {
		System.out.println("Item: " + title + " by " + author + " | Loan: " + getLoanDuration() + " days");
	}
}

interface Reservable {
	void reserveItem();

	boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
	private boolean isAvailable = true;

	public Book(int id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 14;
	}

	@Override
	public void reserveItem() {
		if (isAvailable) {
			isAvailable = false;
			System.out.println("Book reserved.");
		} else {
			System.out.println("Book not available.");
		}
	}

	@Override
	public boolean checkAvailability() {
		return isAvailable;
	}
}

class Magazine extends LibraryItem {
	public Magazine(int id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 7;
	}
}

class DVD extends LibraryItem {
	public DVD(int id, String title, String author) {
		super(id, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 3;
	}
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		LibraryItem[] items = { new Book(1, "Java Basics", "James Gosling"),
				new Magazine(2, "Tech Monthly", "Editorial Team"), new DVD(3, "Code Masterclass", "Online Ed.") };

		for (LibraryItem item : items) {
			item.getItemDetails();
		}

		Book b = (Book) items[0];
		System.out.println("Available: " + b.checkAvailability());
		b.reserveItem();
		System.out.println("Available after reservation: " + b.checkAvailability());
	}
}
