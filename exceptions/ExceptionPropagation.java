package exceptions;

public class ExceptionPropagation {

    public static void main(String[] args) {
        System.out.println("main() starts.");
        try {
            method2();
        } catch (ArithmeticException e) {
            System.err.println("Handled exception in main: " + e.getMessage());
        }
        System.out.println("main() ends.");
    }

    public static void method2() {
        System.out.println("method2() called.");
        method1();
        System.out.println("method2() finishing.");
    }

    public static void method1() {
        System.out.println("method1() called.");
        int result = 10 / 0; 
        System.out.println("method1() finishing.");
    }
}
