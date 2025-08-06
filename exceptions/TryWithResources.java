package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void main(String[] args) {
        String fileName = "info.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            System.out.println("Successfully opened '" + fileName + "'. Reading the first line...");
            String firstLine = reader.readLine();
            
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("The file is empty.");
            }

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}
