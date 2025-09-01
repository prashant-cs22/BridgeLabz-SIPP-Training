package streamAPI;

import java.util.Arrays;
import java.util.List;

public class EventAttendeeWelcomeMessage {
 public static void main(String[] args) {
     List<String> attendees = Arrays.asList("Alice", "Bob", "Charlie", "David");

     attendees.forEach(name -> System.out.println("Welcome, " + name + "! We're glad you could make it."));
 }
}