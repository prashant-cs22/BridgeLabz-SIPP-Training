package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformingNamesForDisplay {
 public static void main(String[] args) {
     List<String> names = Arrays.asList("john doe", "jane smith", "peter jones", "alice brown");

     List<String> transformedNames = names.stream()
         .map(String::toUpperCase)
         .sorted()
         .collect(Collectors.toList());

     transformedNames.forEach(System.out::println);
 }
}