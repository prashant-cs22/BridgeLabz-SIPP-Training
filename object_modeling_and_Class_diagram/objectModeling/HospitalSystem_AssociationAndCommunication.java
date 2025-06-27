package objectModeling;

import java.util.ArrayList;

class Doctor {
    String name;
    ArrayList<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Dr. " + name + " consulted patient " + patient.name);
    }

    void listPatients() {
        System.out.println("Patients of Dr. " + name + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

class Patient {
    String name;
    ArrayList<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }

    void consultDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.consult(this);
    }

    void listDoctors() {
        System.out.println("Doctors for " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
    }
}

class Hospital {
    String name;
    ArrayList<Doctor> doctors = new ArrayList<>();
    ArrayList<Patient> patients = new ArrayList<>();

    Hospital(String name) {
        this.name = name;
    }

    void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        patients.add(patient);
    }

    void listDoctors() {
        System.out.println("Doctors at " + name + ":");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.name);
        }
    }

    void listPatients() {
        System.out.println("Patients at " + name + ":");
        for (Patient p : patients) {
            System.out.println("- " + p.name);
        }
    }
}

public class HospitalSystem_AssociationAndCommunication {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor drSmith = new Doctor("Smith");
        Doctor drJones = new Doctor("Jones");

        Patient john = new Patient("John");
        Patient jane = new Patient("Jane");

        hospital.addDoctor(drSmith);
        hospital.addDoctor(drJones);
        hospital.addPatient(john);
        hospital.addPatient(jane);

        john.consultDoctor(drSmith);
        jane.consultDoctor(drJones);
        john.consultDoctor(drJones); // John sees both doctors

        hospital.listDoctors();
        hospital.listPatients();

        drSmith.listPatients();
        drJones.listPatients();

        john.listDoctors();
        jane.listDoctors();
    }
}
