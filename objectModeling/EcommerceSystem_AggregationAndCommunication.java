package objectModeling;

import java.util.ArrayList;

class Product {
    String name;
    double price;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return name + " (₹" + price + ")";
    }
}

class Order {
    int orderId;
    ArrayList<Product> products = new ArrayList<>();

    Order(int orderId) {
        this.orderId = orderId;
    }

    void addProduct(Product product) {
        products.add(product);
    }

    void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            System.out.println("- " + p);
        }
    }
}

class Customer {
    String name;
    ArrayList<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void placeOrder(Order order) {
        orders.add(order);
    }

    void viewOrders() {
        System.out.println("Orders for " + name + ":");
        for (Order o : orders) {
            o.displayOrderDetails();
        }
    }
}

public class EcommerceSystem_AggregationAndCommunication {
    public static void main(String[] args) {
        Customer customer = new Customer("Govind");

        Product p1 = new Product("Laptop", 75000);
        Product p2 = new Product("Smartphone", 25000);

        Order order1 = new Order(101);
        order1.addProduct(p1);
        order1.addProduct(p2);

        customer.placeOrder(order1);
        customer.viewOrders();
    }
}

