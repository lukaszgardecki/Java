package Zad_43_PasekPostepu;

class Bar {
    private final double increase = 0.5;
    private final int frequency = 1;
    private final int sleepTime = 300;
    private final int endSleepTime = 1500;
    private final char emptySign = '_';
    private final char fullSign = '#';
    private double value = 0;
    private final String emptyBar = Character.toString(emptySign).repeat(100/frequency);
    private StringBuilder load = new StringBuilder(emptyBar);

    void increaseValue() {
        value += increase;
    }

    void draw() throws InterruptedException {
        Thread.sleep(sleepTime);
        String bar = String.format("Wczytywanie %s %.2f%% (%s)\r", getSign(), value, getLoad());
        System.out.print(bar);
        if (value == 100) {
            value = 0;
            load = new StringBuilder(emptyBar);
            Thread.sleep(endSleepTime);
        }
    }

    private String getLoad() {
        if (value > 0 && value % frequency == 0) {
            int i = (int) value / frequency;
            load.setCharAt(i-1, fullSign);
        }
        return load.toString();
    }

    private String getSign() {
        if ((value / increase) % 2 == 0) return "\\";
        return "/";
    }

}
