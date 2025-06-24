package constructorsAndAccessSpecifiers;

class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;

    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }

    boolean borrowBook() {
        if (this.isAvailable) {
            this.isAvailable = false;
            return true;
        }
        return false;
    }

    void displayDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: ₹" + this.price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
}

public class LibraryBookDemo {

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Wings of Fire", "A.P.J. Abdul Kalam", 399);

        System.out.println("Book Details - ");
        book1.displayDetails();
        System.out.println();

        if (book1.borrowBook()) {
            System.out.println("Successfully borrowed the book.");
        } else {
            System.out.println("Sorry, the book is not available.");
        }
        System.out.println();

        System.out.println("After Borrowing - ");
        book1.displayDetails();
    }
}
