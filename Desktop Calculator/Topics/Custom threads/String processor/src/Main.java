import java.util.Scanner;

class StringProcessor extends Thread {

    final Scanner scanner = new Scanner(System.in); // use it to read string from the standard input

    @Override
    public void run() {
        while(true) {
            String line = scanner.nextLine();
            boolean isSmall = false;
            for (int i = 0; i < line.length(); i++) {
                if (Character.isLowerCase(line.charAt(i))) {
                    isSmall = true;
                    break;
                }
            }
            if(isSmall) {
                System.out.println(line.toUpperCase());
            } else {
                System.out.println("FINISHED");
                return;
            }
        }
    }
}