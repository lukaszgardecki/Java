
// Wielowątkowość sposób 1:
//public class Obliczenia extends Thread {
//    @Override
//    public void run() {
//        for (int i = 0; i <= 100; i++) {
//            System.out.println(i + ". ID:" + Thread.currentThread().getId());
//        }
//    }
//}


// Wielowątkowość sposób 2:
// implementujemy interfejs Runnable
//Interfejsy - ciała metod są z góry narzucone typu abstract
public class Obliczenia implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + ". ID:" + Thread.currentThread().getId());
        }
    }
}
