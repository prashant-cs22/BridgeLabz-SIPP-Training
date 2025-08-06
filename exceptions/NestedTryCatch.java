package exceptions;

public class NestedTryCatch {

    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 0};
        int index = 2;
        int divisor = 0;

        try {
            System.out.println("Accessing element at index " + index);
            int element = numbers[index];
            System.out.println("Element is: " + element);

            try {
                System.out.println("Attempting to divide by " + divisor);
                int result = element / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.err.println("Inner Catch: Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Outer Catch: Invalid array index!");
        }

        System.out.println("\nProgram continues after handling exceptions.");
    }
}
