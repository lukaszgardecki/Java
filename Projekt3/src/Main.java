import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//Instrukcja warunkowa IF:
        //Jeżeli a < 10 to zostanie wykonana instrukcja
        int a = 8;
        if (a < 10) {
            System.out.println("a<10");

            if(a==8) //równa się to "==" a nie "==="
                System.out.println("a=8");
            else
                System.out.println("a!=8");
        }
//Instrukcja warunkowa SWITCH, warunek zawsze musi być prawdziwy:
// standardowo jeżeli b nie będzie pasować do żadnego przypadku (case), wtedy nic nie zostanie wydrukowane
        int b = 33;
        switch (b) {
            case 1:
                System.out.println("b=1");
                break; //słowo break przerywa pętlę!
            case 2:
                System.out.println("b=2");
                break;
            case 3:
                System.out.println("b=3");
                break;
            case 4:
                System.out.println("b=4");
                break;
            //w przypadku, gdy wartość b będzie inna niż zdefiniowane przypadki, możemy wyświetlić wartość domyślną.
            //Wartość domyślna default
            default:
                System.out.println("Wpisana wartosc " + b + " nie pasuje do zadnego przypadku!");
        }
// INNY Zapis Ifa:
        int c = 10;
        int d;
        d = c<10 ? -1 : 1; //jeżeli c<10 to przypisz zmiennej d wartość -1, w przeciwnym wypadku przypisz wartość 1
        System.out.println("Otrzymano wartosc: " + d);

        for (int i = 0; i < 10; i++) {
            //.println() drukuje przenosząc do następnej linii
            //.print() drukuje w jednej linii
            System.out.print(i + " ");
            if (i == 5)
                break;
        }
        //dodaj enter:
        System.out.println();

        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }

        Scanner scanner = new Scanner(System.in);

        String name;
        name = scanner.next();

        System.out.println(name);
    }
}
