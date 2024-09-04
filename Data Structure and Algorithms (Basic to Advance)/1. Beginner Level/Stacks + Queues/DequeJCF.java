import java.util.*;
import java.util.LinkedList;

public class DequeJCF {
    public static void dequeInterface() {
        Deque<Integer> d = new LinkedList<>();
        d.addFirst(1);
        d.addFirst(3);
        d.addLast(-1);
        d.addLast(-3);
        System.out.println(d);
        d.removeFirst();
        d.removeLast();
        System.out.println(d);
        System.out.println("First element: " + d.getFirst());
        System.out.println("Last element: " + d.getLast());
    }

    static class Stack {
        Deque<Integer> d = new LinkedList<>();

        public void push(int data) {
            d.addLast(data);
        }

        public int pop() {
            return d.removeLast();
        }

        public int peek() {
            return d.getLast();
        }
    }

    static class Queue {
        Deque<Integer> d = new LinkedList<>();

        public void add(int data) {
            d.addLast(data);
        }

        public int remove() {
            return d.removeFirst();
        }

        public int peek() {
            return d.getFirst();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(2);
        s.push(3);
        s.push(5);
        System.out.println("STACK------>");
        System.out.println("PEEK: " + s.peek());
        System.out.print(s.pop() + " ");
        System.out.print(s.pop() + " ");
        System.out.println(s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(4);
        q.add(9);
        System.out.println("QUEUE------>");
        System.out.print(q.remove() + " ");
        System.out.print(q.remove() + " ");
        System.out.println(q.remove() + " ");
    }
}