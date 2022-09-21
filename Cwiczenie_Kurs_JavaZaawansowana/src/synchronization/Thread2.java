package multithreading;

public class Thread2 implements Runnable{

    MathUtils mu;

    public Thread2(MathUtils mu) {
        this.mu = mu;
    }

    @Override
    public void run() {
        try {
            //System.out.println("Thread 2 is running");
            mu.getMultiples(3);
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}
