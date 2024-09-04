import java.util.*;

public class PQinJava {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        // how to compare object classes
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
            // 0 : obj1 = obj2
            // +ve val : obj1 > obj2
            // -ve val : obj1 < obj2
        }

    }

    public static void pqForObj() {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 10));
        pq.add(new Student("B", 16));
        pq.add(new Student("C", 5));
        pq.add(new Student("D", 3));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + ": " + pq.peek().rank);
            pq.remove();
        }
    }

    public static void pqJCF() {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(); //for ascending order..
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // for descending order

        pq.add(56); // O(log n)
        pq.add(20);
        pq.add(12);
        pq.add(31);
        pq.add(5);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " "); // O(1)
            pq.remove(); // O(log n)
        }
    }

    public static void main(String[] args) {
        pqJCF();
        System.out.println();
        pqForObj();
    }
}
