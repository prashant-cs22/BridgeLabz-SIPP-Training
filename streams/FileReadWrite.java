package streams;

import java.io.*;


public class FileReadWrite {

    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("✅ File copied successfully from " + sourceFile + " to " + destinationFile);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
