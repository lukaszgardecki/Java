import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputTab = scanner.nextLine().split("\\s+");
        int counter = 0;
        int max = 0;
        int ind = 0;

        for (int i = 0; i < inputTab.length; i++) {
            for (int j = 0; j < inputTab[i].length(); j++) {
                counter++;
            }
            if (counter > max) {
                max = counter;
                ind = i;
            }
            counter = 0;
        }
        System.out.println(inputTab[ind]);
    }
}