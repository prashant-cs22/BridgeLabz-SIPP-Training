package this_Static_Final_And_InstanceOf_Keywords;

class Patient {
	static String hospitalName = "Chaumuha city hospital";
	static int totalPatients;
	final int patientID;
	String name;
	int age;
	String ailment;
	
	static void getTotalPatients() {
		System.out.println("Total no. of patients is: " + totalPatients);
		System.out.println();
	}
	
	Patient(int patientID, String name, int age, String ailment) {
		this.patientID = patientID;
		this.name = name;
		this.age = age;
		this.ailment = ailment;
		totalPatients++;
	}
	
	void displayDetails() {
		if(this instanceof Patient) {			
			System.out.println("Patient ID: " + this.patientID);
			System.out.println("Patient name: " + this.name);
			System.out.println("Patient age: " + this.age);
			System.out.println("Patient ailment: " + this.ailment);
			System.out.println();			
		}
	}
}

public class HospitalManagementSystem {

	public static void main(String[] args) {
		Patient patient1 = new Patient(101, "Govind", 20, "headache");
		patient1.displayDetails();
		
		Patient.getTotalPatients();
		
		Patient patient2 = new Patient(102, "Tushar", 21, "Fever");
		patient2.displayDetails();
		
		Patient.getTotalPatients();
	}

}
