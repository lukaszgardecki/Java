import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String ans = "no";
        if(input.length() == 1) {
            System.out.println("yes");
        } else {
            for (int i = 0; i < input.length()/2; i++) {
                String frontSign = Character.toString(input.charAt(i));
                String backSign = Character.toString(input.charAt(input.length()-(i+1)));
                if (!frontSign.equalsIgnoreCase(backSign)) {
                    ans = "no";
                    break;
                } else {
                    ans = "yes";
                }
            }
            System.out.println(ans);
        }


    }
}