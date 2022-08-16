public class Main {

    public static void main(String[] args) {

        // create threads and start them using the class RunnableWorker
        Thread t1 = new Thread(new RunnableWorker(), "worker-5");
        t1.start();
        Thread t2 = new Thread(new RunnableWorker(), "worker-6");
        t2.start();
        Thread t3 = new Thread(new RunnableWorker(), "worker-7");
        t3.start();
    }
}

// Don't change the code below       
class RunnableWorker implements Runnable {

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();

        if (name.startsWith("worker-")) {
            System.out.println("too hard calculations...");
        } else {
            return;
        }
    }
}