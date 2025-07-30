package collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.NoSuchElementException;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.remove();
    }

    public int top() {
        if (q1.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        System.out.println("Push 1, 2, 3");
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top -> " + stack.top());
        System.out.println("Pop -> " + stack.pop());
        System.out.println("Top -> " + stack.top());
    }
}