// Don't delete scanner import
import java.util.Scanner;

class Name {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.next();
        String lastName = scanner.next();
        String full = createFullName(firstName, lastName);
        System.out.println(full);
    }

    public static String createFullName(String first, String last) {
        return first + " " + last;
    }
}