package inheritence;

class Course {
	String courseName;
	String duration;
	
	Course(String courseName, String duration) {
		this.courseName = courseName;
		this.duration  = duration;
	}
	
	void displayDetails() {
		System.out.println("Course name: " + courseName);
		System.out.println("Course duration: " + duration);
	}
}

class OnlineCourse extends Course {
	String platform;
	boolean isRecorded;
	
	OnlineCourse(String courseName, String duration, String platform, boolean isRecorded) {
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("Platform: " + platform);
		System.out.println("Recorded: " + isRecorded);
	}
}

class PaidOnlineCourse extends OnlineCourse {
	double fees;
	float discount;
	
	PaidOnlineCourse(String courseName, String duration, String platform, boolean isRecorded, double fees, float discount) {
		super(courseName, duration, platform, isRecorded);
		this.fees = fees;
		this.discount = discount;
	}
	
	@Override
	void displayDetails() {
		super.displayDetails();
		System.out.println("fees: " + fees);
		System.out.println("Discount: " + discount + " %");
		System.out.println();
	}
}

public class EducationalCourseSystem {

	public static void main(String[] args) {
		Course course = new PaidOnlineCourse("Java", "5 hours", "BridgeLabz", true, 20000, 20);
		course.displayDetails();
	}

}
