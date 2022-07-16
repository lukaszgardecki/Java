// You can experiment here, it won’t be checked
import java.util.Scanner;

public class Task {
  public static void main(String[] args) {
    // put your code here
    Scanner scanner = new Scanner(System.in);
    String type = scanner.nextLine();
    long num = scanner.nextLong();

    if ("long".equals(type)) {
      getMaxMinusCurrent(num);
    } else if ("int".equals(type)) {
      getMaxMinusCurrent((int)num);
    }

  }
  public static long getMaxMinusCurrent(long val) {
    return Long.MAX_VALUE - val;
  }

  public static int getMaxMinusCurrent(int val) {
    return Integer.MAX_VALUE - val;
  }

}
