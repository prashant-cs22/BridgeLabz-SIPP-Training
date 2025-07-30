package collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ShoppingCart {
    public static void main(String[] args) {
        Map<String, Double> productPrices = new HashMap<>(Map.of("Apple", 0.50, "Banana", 0.30, "Milk", 2.50));
        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

        System.out.println("--- Use LinkedHashMap to maintain cart order ---");
        cart.put("Banana", 2);
        cart.put("Milk", 1);
        cart.put("Apple", 3);
        System.out.println("Cart contents (insertion order): " + cart);

        System.out.println("\n--- Use TreeMap to display cart sorted by price ---");
        Comparator<String> priceComparator = Comparator.comparing(productPrices::get);
        Map<String, Integer> sortedCart = new TreeMap<>(priceComparator);
        sortedCart.putAll(cart);
        System.out.println("Cart contents (sorted by price): " + sortedCart);
    }
}