package collectors;
import java.util.*;
import java.util.stream.Collectors;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;

class Student {
	String name;
	String grade;
	
	Student(String name, String grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getGrade() {
		return grade;
	}
}

public class StudentGrouping {
	public static void main(String[] args) {
       List<Student> students = Arrays.asList(
               new Student("Alice", "A"),
               new Student("Bob", "B"),
               new Student("Charlie", "A"),
               new Student("David", "C"),
               new Student("Eve", "B")
           );
       
       Map<String, List<Student>> studentsByGrades = students.stream().collect(Collectors.groupingBy(student -> student.getGrade()));
       
       studentsByGrades.forEach((grade, studentList) -> {
    	   System.out.println("Grade: " + grade);
    	   studentList.forEach(student -> System.out.println(" " + student.getName()));
       });
	}
}
