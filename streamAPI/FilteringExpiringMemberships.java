package streamAPI;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Member {
 private String name;
 private LocalDate expiryDate;

 public Member(String name, LocalDate expiryDate) {
     this.name = name;
     this.expiryDate = expiryDate;
 }

 public String getName() {
     return name;
 }

 public LocalDate getExpiryDate() {
     return expiryDate;
 }

 @Override
 public String toString() {
     return "Member{" +
            "name='" + name + '\'' +
            ", expiryDate=" + expiryDate +
            '}';
 }
}

public class FilteringExpiringMemberships {
 public static void main(String[] args) {
     LocalDate today = LocalDate.now();
     List<Member> members = Arrays.asList(
         new Member("Alice", today.plusDays(10)),
         new Member("Bob", today.plusDays(45)),
         new Member("Charlie", today.plusDays(25)),
         new Member("David", today.plusDays(60)),
         new Member("Eve", today.plusDays(5))
     );

     List<Member> expiringMembers = members.stream()
         .filter(m -> m.getExpiryDate().isBefore(today.plusDays(30)))
         .collect(Collectors.toList());

     expiringMembers.forEach(System.out::println);
 }
}