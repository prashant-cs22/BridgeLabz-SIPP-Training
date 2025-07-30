package collection;

import java.util.PriorityQueue;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', severity=" + severity + "}";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();

        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));
        triageQueue.add(new Patient("Mary", 4));

        System.out.println("Triage Queue (Patients to be treated):");
        while (!triageQueue.isEmpty()) {
            Patient nextPatient = triageQueue.poll();
            System.out.println("Treating: " + nextPatient);
        }
    }
}