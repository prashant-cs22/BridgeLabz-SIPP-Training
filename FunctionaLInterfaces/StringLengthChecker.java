package interfaces;

import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String,Integer> lengthCheck = s -> s.length();
        System.out.println(lengthCheck.apply("Hello World"));
    }
}
