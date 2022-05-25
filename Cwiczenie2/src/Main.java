import java.util.Scanner;

    //Zamiana dwóch liczb

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczbę pierwsza");
        int firstNumber = scanner.nextInt();

        System.out.println("Podaj liczbe druga");
        int secondNumber = scanner.nextInt();

        System.out.println("Wartosci przed: ");
        System.out.println(firstNumber+" "+secondNumber);

        int pomoc = secondNumber;

        secondNumber = firstNumber;
        firstNumber = pomoc;

        System.out.println("Wartosci po zamianie: ");
        System.out.println(firstNumber+" "+secondNumber);


    }
}
