public class MTByRunnableInterface implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        MTByRunnableInterface runIn = new MTByRunnableInterface();
        // Thread(Runnable r)
        Thread thread = new Thread(runIn);
        thread.start();
        
        // using Thread(Runnable r, String str)
        Thread thread2 = new Thread(runIn, "My new Thread");
        thread2.start();
        // this will execute first then run method would do its job
        System.out.println(thread2.getName());
    }
}
