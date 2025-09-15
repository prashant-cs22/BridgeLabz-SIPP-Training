package streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Doctor {
 private String name;
 private String specialty;
 private Set<String> availableDays;

 public Doctor(String name, String specialty, Set<String> availableDays) {
     this.name = name;
     this.specialty = specialty;
     this.availableDays = availableDays;
 }

 public String getSpecialty() {
     return specialty;
 }

 public Set<String> getAvailableDays() {
     return availableDays;
 }

 @Override
 public String toString() {
     return "Doctor{" +
            "name='" + name + '\'' +
            ", specialty='" + specialty + '\'' +
            '}';
 }
}

public class HospitalDoctorAvailability {
 public static void main(String[] args) {
     List<Doctor> doctors = Arrays.asList(
         new Doctor("Dr. Smith", "Cardiology", Set.of("Monday", "Wednesday", "Saturday")),
         new Doctor("Dr. Jones", "Dermatology", Set.of("Tuesday", "Friday")),
         new Doctor("Dr. Miller", "Neurology", Set.of("Saturday", "Sunday")),
         new Doctor("Dr. Davis", "Pediatrics", Set.of("Monday", "Tuesday", "Sunday")),
         new Doctor("Dr. Wilson", "Cardiology", Set.of("Friday", "Saturday"))
     );

     List<Doctor> weekendDoctors = doctors.stream()
         .filter(d -> d.getAvailableDays().contains("Saturday") || d.getAvailableDays().contains("Sunday"))
         .sorted(Comparator.comparing(Doctor::getSpecialty))
         .collect(Collectors.toList());

     weekendDoctors.forEach(System.out::println);
 }
}
