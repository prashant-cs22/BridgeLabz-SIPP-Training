package streams;

import java.io.*;

public class UpperCaseToLowerCase {

    public static void main(String[] args) {
        String inputFile = "mixedCase.txt";
        String outputFile = "lowerCase.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            int character;
            while ((character = reader.read()) != -1) {
                // Convert character to lowercase and write to the output file
                writer.write(Character.toLowerCase(character));
            }

            System.out.println("✅ File content converted to lowercase and saved to " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found: " + inputFile);
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }
}
