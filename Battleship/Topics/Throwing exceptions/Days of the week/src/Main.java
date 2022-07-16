import java.util.*;

public class Main {

    public static String getDayOfWeekName(int number) throws IllegalArgumentException{
        // write your code here
        String x = "";
        switch (number) {
            case 1:
                x = "Mon";
                break;
            case 2:
                x = "Tue";
                break;
            case 3:
                x = "Wed";
                break;
            case 4:
                x = "Thu";
                break;
            case 5:
                x = "Fri";
                break;
            case 6:
                x = "Sat";
                break;
            case 7:
                x = "Sun";
                break;
            default:
                throw new IllegalArgumentException();
        }
        return x;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dayNumber = scanner.nextInt();
        try {
            System.out.println(getDayOfWeekName(dayNumber));
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
        }
    }
}