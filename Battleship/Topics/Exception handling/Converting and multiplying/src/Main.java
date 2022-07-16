import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        List<String> nums = new ArrayList<>();
        String tmp = "";

        // add elements to String list
        while(true) {
            tmp = scanner.next();

            if ("0".equals(tmp)) {
                break;
            } else {
                nums.add(tmp);
            }
        }

        // second list to store the integer numbers
        List <Integer> nums2 = new ArrayList<>();

        for (int j = 0; j < nums.size(); j++) {
            try {
                nums2.add(j, Integer.parseInt(nums.get(j)));
                System.out.println(nums2.get(j) * 10);

            } catch(NumberFormatException e) {
                nums2.add(j, 0);
                System.out.println("Invalid user input: " + nums.get(j));
            }
        }

    }
}