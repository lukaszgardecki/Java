import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        Time n = new Time();
        n.hour = 12;
        n.minute = 0;
        n.second = 0;
        return n;
    }

    public static Time midnight() {
        Time m = new Time();
        m.hour = 0;
        m.minute = 0;
        m.second = 0;
        return m;
    }

    public static Time ofSeconds(long seconds) {
        Time o = new Time();
        seconds = Math.abs(seconds);
        long hours = (seconds / 3600) % 24;
        long minutes = (seconds / 60) % 60;
        long sec = seconds % 60;

        o.hour = (int) hours;
        o.minute = (int) minutes;
        o.second = (int) sec;
        return o;
    }

    public static Time of(int hour, int minute, int second) {
        Time t = new Time();
        boolean isOK = hour >= 0 && hour <=23 && minute >= 0 & minute <=59 && second >= 0 && second <= 59;
        if(isOK) {
            t.hour = hour;
            t.minute = minute;
            t.second = second;
            return t;
        } else {
            return null;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.printf("%s %s %s", time.hour, time.minute, time.second);
        }
    }
}