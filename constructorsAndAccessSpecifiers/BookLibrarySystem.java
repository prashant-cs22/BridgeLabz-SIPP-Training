package constructorsAndAccessSpecifiers;

class BaseBook {
    public String isbn;
    protected String title;
    private String author;

    BaseBook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }

    void displayDetails() {
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
    }
}

class EBook extends BaseBook {
    private double fileSizeMB;

    EBook(String isbn, String title, String author, double fileSizeMB) {
        super(isbn, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    void displayEBookDetails() {
        System.out.println("EBook");
        System.out.println("ISBN: " + this.isbn);      // public
        System.out.println("Title: " + this.title);    // protected
        System.out.println("File Size: " + this.fileSizeMB + " MB");
    }
}

public class BookLibrarySystem {

    public static void main(String[] args) {
        BaseBook b1 = new BaseBook("978-0-13-468599-1", "Effective Java", "Joshua Bloch");
        b1.displayDetails();
        System.out.println();

        EBook ebook1 = new EBook("978-1-23456-789-0", "Java Design Patterns", "Richard Helm", 2.5);
        ebook1.displayEBookDetails();
    }
}
