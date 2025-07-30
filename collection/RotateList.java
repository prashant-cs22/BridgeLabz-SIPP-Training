package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateList {

    public static <T> void rotate(List<T> list, int k) {
        if (list == null || list.isEmpty() || k <= 0) {
            return;
        }

        int size = list.size();
        k = k % size;

        List<T> sublistToMove = new ArrayList<>(list.subList(0, k));

        list.subList(0, k).clear();

        list.addAll(sublistToMove);
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        System.out.println("Original List: " + numbers);
        System.out.println("Rotate by: " + rotateBy);

        rotate(numbers, rotateBy);
        System.out.println("Rotated List: " + numbers); 
    }
}
