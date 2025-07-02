package Encapsulation_Polymorphism_InterfaceandAbstractClass;

//HospitalPatientManagement.java

abstract class Patient {
	private int patientId;
	private String name;
	private int age;

	public Patient(int patientId, String name, int age) {
		this.patientId = patientId;
		this.name = name;
		this.age = age;
	}

	public int getPatientId() {
		return patientId;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public abstract double calculateBill();

	public void getPatientDetails() {
		System.out.println("Patient: " + name + " | ID: " + patientId + " | Age: " + age);
	}
}

interface MedicalRecord {
	void addRecord(String note);

	void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
	private int daysAdmitted;
	private double dailyRate;
	private String medicalHistory = "";

	public InPatient(int id, String name, int age, int daysAdmitted, double dailyRate) {
		super(id, name, age);
		this.daysAdmitted = daysAdmitted;
		this.dailyRate = dailyRate;
	}

	@Override
	public double calculateBill() {
		return daysAdmitted * dailyRate;
	}

	@Override
	public void addRecord(String note) {
		medicalHistory += note + "\n";
	}

	@Override
	public void viewRecords() {
		System.out.println("Medical History:\n" + medicalHistory);
	}
}

class OutPatient extends Patient implements MedicalRecord {
	private double consultationFee;
	private String visitNotes = "";

	public OutPatient(int id, String name, int age, double consultationFee) {
		super(id, name, age);
		this.consultationFee = consultationFee;
	}

	@Override
	public double calculateBill() {
		return consultationFee;
	}

	@Override
	public void addRecord(String note) {
		visitNotes += note + "\n";
	}

	@Override
	public void viewRecords() {
		System.out.println("Consultation Notes:\n" + visitNotes);
	}
}

public class HospitalPatientManagement {
	public static void main(String[] args) {
		Patient[] patients = { new InPatient(1, "Sita", 45, 4, 2500), new OutPatient(2, "Lakshman", 30, 500) };

		for (Patient p : patients) {
			p.getPatientDetails();
			System.out.println("Bill: ₹" + p.calculateBill());

			if (p instanceof MedicalRecord record) {
				record.addRecord("Initial checkup complete.");
				record.viewRecords();
			}
			System.out.println("------------------------");
		}
	}
}
