package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class CircularBuffer {
    private final Queue<Integer> queue;
    private final int capacity;

    public CircularBuffer(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void insert(int element) {
        if (queue.size() == capacity) {
            queue.remove();
        }
        queue.add(element);
    }

    public void display() {
        System.out.println("Buffer: " + queue.toString());
    }

    public static void main(String[] args) {
        CircularBuffer buffer = new CircularBuffer(3);
        
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        buffer.display();

        System.out.println("Insert 4");
        buffer.insert(4);
        buffer.display();
    }
}