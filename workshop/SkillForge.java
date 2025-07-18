package workshop;

import java.util.*;

//Certificate interface
interface ICertifiable {
	String generateCertificate();
}

//Abstract User class
abstract class User {
	protected String name;
	protected String email;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public abstract void displayInfo();
}

//Student subclass
class Student extends User {
	private List<Course> enrolledCourses;
	private Map<Course, Integer> progress; // % completion

	public Student(String name, String email) {
		super(name, email);
		enrolledCourses = new ArrayList<>();
		progress = new HashMap<>();
	}

	public void enroll(Course course) {
		enrolledCourses.add(course);
		progress.put(course, 0);
		System.out.println(name + " enrolled in: " + course.getTitle());
	}

	public void updateProgress(Course course, int percent) {
		if (progress.containsKey(course)) {
			progress.put(course, percent);
		}
	}

	public void displayInfo() {
		System.out.println("Student: " + name + ", Email: " + email);
	}

	public void checkCertification(Course course) {
		if (course instanceof ICertifiable && progress.get(course) >= 100) {
			System.out.println(((ICertifiable) course).generateCertificate());
		} else {
			System.out.println("Course not completed or not certifiable.");
		}
	}
}

//Instructor subclass
class Instructor extends User {
	private List<Course> uploadedCourses;

	public Instructor(String name, String email) {
		super(name, email);
		uploadedCourses = new ArrayList<>();
	}

	public Course uploadCourse(String title, double rating, String level, String... modules) {
		Course course = new Course(title, this, rating, level, Arrays.asList(modules));
		uploadedCourses.add(course);
		return course;
	}

	public void displayInfo() {
		System.out.println("Instructor: " + name + ", Email: " + email);
	}
}

//Course class with encapsulation and polymorphism
class Course implements ICertifiable {
	private String title;
	private Instructor instructor;
	private double rating;
	private final List<String> modules;
	private final List<String> internalReviews;

	private String level; // "Beginner", "Intermediate", "Advanced"

	public Course(String title, Instructor instructor, double rating, String level, List<String> modules) {
		this.title = title;
		this.instructor = instructor;
		this.rating = Math.max(0.0, Math.min(5.0, rating)); // Encapsulation: rating logic
		this.level = level;
		this.modules = new ArrayList<>(modules);
		this.internalReviews = new ArrayList<>();
	}

	public String getTitle() {
		return title;
	}

	public double getRating() {
		return rating;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public List<String> getModules() {
		return Collections.unmodifiableList(modules);
	}

	public List<String> getInternalReviews() {
		return Collections.unmodifiableList(internalReviews); // Read-only reviews
	}

	public void addInternalReview(String review) {
		internalReviews.add(review);
	}

	@Override
	public String generateCertificate() {
		return switch (level.toLowerCase()) {
		case "beginner" -> "**Beginner Level Certificate**\nCongratulations!";
		case "intermediate" -> "**Intermediate Level Certificate**\nWell Done!";
		case "advanced" -> "**Advanced Level Certificate**\nExceptional Work!";
		default -> "**Generic Certificate**\nCourse Completed!";
		};
	}
}

//File: SkillForgeDemo.java

public class SkillForge {
 public static void main(String[] args) {
     Instructor profRao = new Instructor("Prof. Rao", "rao@skillforge.com");
     Student govind = new Student("Govind", "govind@learn.com");

     Course dsCourse = profRao.uploadCourse(
         "Data Structures", 4.8, "Intermediate", "Arrays", "LinkedLists", "Stacks", "Queues"
     );

     govind.enroll(dsCourse);
     govind.updateProgress(dsCourse, 100);
     govind.checkCertification(dsCourse);
 }
}

