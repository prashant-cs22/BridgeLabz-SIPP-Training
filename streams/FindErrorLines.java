package streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FindErrorLines {

    public static void main(String[] args) {
        String filePath = "large_log_file.txt";
        String searchTerm = "error";
        int lineNumber = 0;

        System.out.println("Searching for lines containing '" + searchTerm + "' in " + filePath + "...\n");

        // Use try-with-resources for efficient memory usage and automatic closing
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                lineNumber++;
                // Case-insensitive search
                if (currentLine.toLowerCase().contains(searchTerm.toLowerCase())) {
                    System.out.printf("Line %d: %s%n", lineNumber, currentLine);
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}