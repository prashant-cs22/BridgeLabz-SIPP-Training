package streams;

import java.io.*;

public class StudentData {

    public static void main(String[] args) {
        String fileName = "students.dat";

        // --- Write Primitive Data ---
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            System.out.println("Writing student data to " + fileName);
            // Student 1
            dos.writeInt(1);
            dos.writeUTF("John Doe");
            dos.writeDouble(3.8);
            // Student 2
            dos.writeInt(2);
            dos.writeUTF("Jane Smith");
            dos.writeDouble(4.0);
            
            System.out.println("✅ Data written successfully.");

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
        
        System.out.println("\n--- Reading Primitive Data ---");

        // --- Read Primitive Data ---
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Reading student data from " + fileName);
            // Keep reading as long as there is data available
            while (dis.available() > 0) {
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.printf("Roll: %d, Name: %s, GPA: %.2f%n", roll, name, gpa);
            }
        } catch (EOFException e) {
            // This is expected when the end of the file is reached.
            System.out.println("End of file reached.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}