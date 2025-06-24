package constructorsAndAccessSpecifiers;

class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;

    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + this.productName);
        System.out.println("Price: ₹" + this.price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
}

public class ProductInventory {

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 25000);

        System.out.println("Product 1 - ");
        p1.displayProductDetails();
        System.out.println();

        System.out.println("Product 2 - ");
        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
