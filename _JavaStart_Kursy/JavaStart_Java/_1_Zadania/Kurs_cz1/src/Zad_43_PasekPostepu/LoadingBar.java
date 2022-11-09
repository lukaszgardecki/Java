package Zad_43_PasekPostepu;

class LoadingBar {
    static Bar bar = new Bar();

    public static void main(String[] args) throws InterruptedException {
        while (true) displayLoadingBar();
    }

    private static void displayLoadingBar() throws InterruptedException {
        bar.increaseValue();
        bar.draw();
    }
}
