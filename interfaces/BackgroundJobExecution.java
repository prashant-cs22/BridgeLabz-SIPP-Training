package interfaces;

public class BackgroundJobExecution {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Job executed");
        Thread t = new Thread(job);
        t.start();
    }
}
