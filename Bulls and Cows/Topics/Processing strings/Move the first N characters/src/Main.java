import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tab = scanner.nextLine().split("\\s+");
        if(Integer.parseInt(tab[1]) > tab[0].length()) {
            System.out.println(tab[0]);
        } else {
            String firstPart = tab[0].substring(0,Integer.parseInt(tab[1]));
            String secondPart = tab[0].substring(Integer.parseInt(tab[1]));
            System.out.println(secondPart + firstPart);
        }
    }
}