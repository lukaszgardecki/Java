package TryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dzielenie {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        boolean isNotCorrect = true;

        do {

            //Spróbuj wykonaæ ten kawa³ek kodu:
            try {
                System.out.println("WprowadŸ licznik");
                int l = skaner.nextInt();
                System.out.println("WprowadŸ mianownik");
                int m = skaner.nextInt();

                System.out.println("Wynik dzielenia " + l + " / " + m + " = " + l / m);

                isNotCorrect = false;





                //jeœli u¿ytkownik bêdzie chcia³ podzieliæ przez 0, wtedy wyst¹pi b³¹d (wyj¹tek). Wiêc w kontrolowany sposób wyœwietl komunikat:
            } catch (ArithmeticException ae) {
                //ae.printStackTrace();
                System.err.println("Wyj¹tek - Dzielenie przez zero!");

                System.out.println("WprowadŸ dane ponownie");



                //jeœli u¿ytkownik bêdzie chcia³ wpisaæ wartoœæ inn¹ ni¿ Integer, tzn. np jakiœ String, wtedy wyst¹pi b³¹d (wyj¹tek). Wiêc w kontrolowany sposób wyœwietl komunikat:
            } catch (InputMismatchException ime) {
                //ime.printStackTrace();
                System.err.println("Z³e dane wejœciowe! WprowadŸ liczbê!");
                skaner.nextLine();
                System.out.println("WprowadŸ dane ponownie");

            }

        } while (isNotCorrect);




    }
}
