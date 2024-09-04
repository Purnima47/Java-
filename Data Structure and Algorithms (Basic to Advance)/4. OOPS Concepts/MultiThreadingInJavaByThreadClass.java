// by extending thread class
public class MultiThreadingInJavaByThreadClass extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        MultiThreadingInJavaByThreadClass thread = new MultiThreadingInJavaByThreadClass();
        thread.start();

        // using Thread(String)
        Thread thread2 = new Thread("My First Thread");
        thread2.start();
        System.out.println(thread2.getName());
    }
}
