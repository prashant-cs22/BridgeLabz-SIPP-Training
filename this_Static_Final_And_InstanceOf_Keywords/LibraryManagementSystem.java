package this_Static_Final_And_InstanceOf_Keywords;

class Book {
    static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("ISBN: " + isbn);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book b1 = new Book("123-A", "Clean Code", "Robert C. Martin");
        Book b2 = new Book("456-B", "Effective Java", "Joshua Bloch");

        b1.displayBookDetails();
        System.out.println();
        b2.displayBookDetails();
        System.out.println();

        Book.displayLibraryName();
    }
}

