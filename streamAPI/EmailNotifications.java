package streamAPI;

import java.util.Arrays;
import java.util.List;

public class EmailNotifications {
 public static void main(String[] args) {
     List<String> emails = Arrays.asList("user1@example.com", "user2@example.com", "user3@example.com");

     emails.forEach(email -> sendEmailNotification(email));
 }

 public static void sendEmailNotification(String email) {
     System.out.println("Sending email notification to: " + email);
 }
}
