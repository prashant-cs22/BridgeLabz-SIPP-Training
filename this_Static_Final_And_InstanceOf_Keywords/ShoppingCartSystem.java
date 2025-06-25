package this_Static_Final_And_InstanceOf_Keywords;

class Product {
    static double discount = 10.0;
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: ₹" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product(201, "Laptop", 50000, 1);
        Product p2 = new Product(202, "Mouse", 799, 2);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();

        Product.updateDiscount(15.0);
        System.out.println("Updated Discount: " + Product.discount + "%");
    }
}

