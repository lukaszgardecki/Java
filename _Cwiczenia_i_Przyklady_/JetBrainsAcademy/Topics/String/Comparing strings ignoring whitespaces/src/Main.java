import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        boolean equals = input1.trim().replaceAll(" ", "").equals(input2.trim().replaceAll(" ", ""));
        System.out.println(equals);
    }
}