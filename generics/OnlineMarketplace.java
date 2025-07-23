package generics;

import java.util.ArrayList;
import java.util.List;

abstract class Product {
    protected String name;
    protected double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-20s - $%.2f", name, price);
    }
}

class Book extends Product {
    public Book(String name, double price) {
        super(name, price);
    }
}

class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }
}

class Gadget extends Product {
    public Gadget(String name, double price) {
        super(name, price);
    }
}

public class OnlineMarketplace {

    public static <T extends Product> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountAmount = currentPrice * (percentage / 100.0);
        product.setPrice(currentPrice - discountAmount);
        System.out.println("Applied " + percentage + "% discount to '" + product.name + "'.");
    }

    public static void main(String[] args) {
        Book book = new Book("Effective Java", 50.00);
        Clothing shirt = new Clothing("Cotton T-Shirt", 25.00);
        Gadget phone = new Gadget("Latest Smartphone", 999.00);
        
        List<Product> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);
        
        System.out.println("--- Initial Product Catalog ---");
        catalog.forEach(System.out::println);
        System.out.println("-------------------------------\n");

        applyDiscount(book, 10);
        applyDiscount(shirt, 20);
        
        System.out.println("\n--- Product Catalog After Discounts ---");
        catalog.forEach(System.out::println);
        System.out.println("---------------------------------------");
    }
}