package exceptions;

public class MultipleCatchBlocks {

    public static void main(String[] args) {
        performOperation(new int[]{10, 20, 30}, 1);

        System.out.println("\n--------------------------\n");

        performOperation(new int[]{10, 20, 30}, 5);
        
        System.out.println("\n--------------------------\n");

        performOperation(null, 0);
    }

    public static void performOperation(int[] arr, int index) {
        try {
            System.out.println("Attempting to access index " + index + "...");
            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Invalid index! The array does not have an element at index " + index + ".");
        } catch (NullPointerException e) {
            System.err.println("Error: Array is not initialized! It is null.");
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
