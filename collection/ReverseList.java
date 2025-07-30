package collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {


    public static <T> void reverse(List<T> list) {
        if (list == null || list.size() <= 1) {
            return; // No need to reverse
        }
        int size = list.size();
        for (int i = 0; i < size / 2; i++) {
            // Swap elements at opposite ends
            T temp = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, temp);
        }
    }

    public static void main(String[] args) {
        // --- Example with ArrayList ---
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original ArrayList: " + arrayList);
        reverse(arrayList);
        System.out.println("Reversed ArrayList: " + arrayList); 

        System.out.println("--------------------");

        // --- Example with LinkedList ---
        List<String> linkedList = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        System.out.println("Original LinkedList: " + linkedList);
        reverse(linkedList);
        System.out.println("Reversed LinkedList: " + linkedList); // Output: [D, C, B, A]
    }
}