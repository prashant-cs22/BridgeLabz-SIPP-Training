package constructorsAndAccessSpecifiers;

class Book {
    private String title;
    private String author;
    private double price;

    Book() {
        this("Untitled", "Unknown", 0.0);
    }

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("Price: ₹" + this.price);
    }
}

public class BookClass {

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 499);

        System.out.println("Book 1 - ");
        book1.displayDetails();
        System.out.println();

        System.out.println("Book 2 - ");
        book2.displayDetails();
    }
}
