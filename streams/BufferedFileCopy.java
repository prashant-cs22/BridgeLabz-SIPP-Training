package streams;

import java.io.*;

public class BufferedFileCopy {

    public static void main(String[] args) throws IOException {
        String sourceFile = "largeFile.txt";
        String unbufferedDest = "unbufferedCopy.txt";
        String bufferedDest = "bufferedCopy.txt";
        int bufferSize = 4096; // 4 KB

        // --- Unbuffered Stream Copy ---
        long startTime = System.nanoTime();
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(unbufferedDest)) {
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
        long endTime = System.nanoTime();
        long unbufferedTime = (endTime - startTime) / 1_000_000; // milliseconds
        System.out.println("Unbuffered stream copy time: " + unbufferedTime + " ms");

        // --- Buffered Stream Copy ---
        startTime = System.nanoTime();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(bufferedDest))) {
            byte[] buffer = new byte[bufferSize];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
        endTime = System.nanoTime();
        long bufferedTime = (endTime - startTime) / 1_000_000; // milliseconds
        System.out.println("Buffered stream copy time: " + bufferedTime + " ms");

        System.out.println("\n💡 Buffered streams are significantly faster for large files!");
    }
}