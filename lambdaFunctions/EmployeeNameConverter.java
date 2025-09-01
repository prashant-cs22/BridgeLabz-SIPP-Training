package lambdaFunctions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeNameConverter {

    public static void main(String[] args) {
        List<String> employeeNames = Arrays.asList("alice", "bob", "charlie");

        List<String> uppercaseNames = employeeNames.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());

        System.out.println("Original names: " + employeeNames);
        System.out.println("Uppercase names: " + uppercaseNames);
    }
}
