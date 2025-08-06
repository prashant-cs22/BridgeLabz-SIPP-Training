package exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class CheckedException {

    public static void main(String[] args) {
        String fileName = "data.txt";
        
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println("File '" + fileName + "' found. Contents:");
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found: '" + fileName + "'");
        } catch (IOException e) {
            System.out.println("Error reading file '" + fileName + "': " + e.getMessage());
        }
    }
}
