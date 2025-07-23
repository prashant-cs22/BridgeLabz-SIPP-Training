package generics;
import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }
}

class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
        System.out.println("Added '" + item.getName() + "' to a specialized storage unit.");
    }

    public List<T> getItems() {
        return new ArrayList<>(items);
    }
}

public class SmartWarehouseSystem {

    public static void displayAllItems(List<? extends WarehouseItem> items) {
        System.out.println("\n--- Displaying Items in a List ---");
        for (WarehouseItem item : items) {
            System.out.println("- " + item.getName());
        }
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        
        electronicsStorage.addItem(new Electronics("4K Smart TV"));
        electronicsStorage.addItem(new Electronics("Gaming Laptop"));
        groceryStorage.addItem(new Groceries("Organic Apples"));
        groceryStorage.addItem(new Groceries("Almond Milk"));

        List<WarehouseItem> allItemsInWarehouse = new ArrayList<>();
        allItemsInWarehouse.addAll(electronicsStorage.getItems());
        allItemsInWarehouse.addAll(groceryStorage.getItems());
        allItemsInWarehouse.add(new Furniture("Ergonomic Office Chair"));

        displayAllItems(allItemsInWarehouse);

        displayAllItems(electronicsStorage.getItems());
    }
}