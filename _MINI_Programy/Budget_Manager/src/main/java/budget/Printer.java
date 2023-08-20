package budget;

public class Printer {


    public void println() {
        System.out.println();
    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void printf(String format, Object... args) {
        System.out.format(format, args);
    }
}
