package multithreading;

public class Thread1 extends Thread {

    MathUtils mu;

    public Thread1(MathUtils mu) {
        this.mu = mu;
    }


    @Override
    public void run() {
        try {
            //System.out.println("Thread1 is running");
            mu.getMultiples(2);

        } catch (Exception e) {
            System.out.println("Exception raised " + e);
        }
    }
}
