package streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateLargeFiles {

    public static void main(String[] args) {
        // Generate a 100MB file for the copy test
        createFile("largeFile.txt", 100); 
        
        // Generate a 500MB file for the error search test
        createFile("large_log_file.txt", 500); 
    }

    private static void createFile(String fileName, int sizeInMB) {
        System.out.println("Generating " + fileName + " (" + sizeInMB + " MB)...");
        long targetSize = (long) sizeInMB * 1024 * 1024; // Convert MB to bytes
        String line1 = "This is a sample line of text for the large file. ";
        String lineWithError = "An unexpected error occurred during processing. Please check the logs. ";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            long currentSize = 0;
            int linesWritten = 0;
            while (currentSize < targetSize) {
                // Every 1000 lines, insert a line with the word "error"
                if (linesWritten % 1000 == 0) {
                    writer.write(lineWithError);
                    currentSize += lineWithError.length();
                } else {
                    writer.write(line1);
                    currentSize += line1.length();
                }
                writer.newLine();
                linesWritten++;
            }
            System.out.println("✅ Successfully created " + fileName);
        } catch (IOException e) {
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}