package lambdaFunctions;

import java.util.Arrays;
import java.util.List;

public class PatientIdPrinter {

    public static void main(String[] args) {
        List<Patient> patients = Arrays.asList(
            new Patient("P1001"),
            new Patient("P1002"),
            new Patient("P1003")
        );

        System.out.print("Printing patient IDs: ");
        patients.forEach(PatientIdPrinter::printPatientId);
        System.out.println();
    }

    public static void printPatientId(Patient patient) {
        System.out.print(patient.getId() + " ");
    }

    static class Patient {
        private String id;
        public Patient(String id) {
            this.id = id;
        }
        public String getId() { return id; }
    }
}
