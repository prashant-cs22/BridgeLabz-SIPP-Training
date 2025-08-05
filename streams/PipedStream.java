package streams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStream {

    public static void main(String[] args) throws IOException {
        // Create connected piped streams
        final PipedOutputStream pos = new PipedOutputStream();
        final PipedInputStream pis = new PipedInputStream(pos);

        // --- Writer Thread ---
        Thread writerThread = new Thread(() -> {
            try {
                System.out.println("Writer: Starting to write data...");
                pos.write("Hello from the writer thread!\n".getBytes());
                Thread.sleep(1000);
                pos.write("This is the second message.\n".getBytes());
                Thread.sleep(1000);
                pos.write("End of communication.".getBytes());
            } catch (IOException | InterruptedException e) {
                System.err.println("Writer thread error: " + e.getMessage());
            } finally {
                try {
                    pos.close(); // Closing the output stream signals the end to the reader
                    System.out.println("Writer: Closed pipe.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // --- Reader Thread ---
        Thread readerThread = new Thread(() -> {
            try {
                System.out.println("Reader: Waiting for data...");
                int data;
                StringBuilder sb = new StringBuilder();
                while ((data = pis.read()) != -1) {
                    sb.append((char) data);
                }
                System.out.println("Reader received: \n" + sb.toString());
            } catch (IOException e) {
                System.err.println("Reader thread error: " + e.getMessage());
            } finally {
                try {
                    pis.close();
                    System.out.println("Reader: Closed pipe.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        writerThread.start();
        readerThread.start();
    }
}