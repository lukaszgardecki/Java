package TryCatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dzielenie {
    public static void main(String[] args) {
        Scanner skaner = new Scanner(System.in);
        boolean isNotCorrect = true;

        do {

            //Spr�buj wykona� ten kawa�ek kodu:
            try {
                System.out.println("Wprowad� licznik");
                int l = skaner.nextInt();
                System.out.println("Wprowad� mianownik");
                int m = skaner.nextInt();

                System.out.println("Wynik dzielenia " + l + " / " + m + " = " + l / m);

                isNotCorrect = false;





                //je�li u�ytkownik b�dzie chcia� podzieli� przez 0, wtedy wyst�pi b��d (wyj�tek). Wi�c w kontrolowany spos�b wy�wietl komunikat:
            } catch (ArithmeticException ae) {
                //ae.printStackTrace();
                System.err.println("Wyj�tek - Dzielenie przez zero!");

                System.out.println("Wprowad� dane ponownie");



                //je�li u�ytkownik b�dzie chcia� wpisa� warto�� inn� ni� Integer, tzn. np jaki� String, wtedy wyst�pi b��d (wyj�tek). Wi�c w kontrolowany spos�b wy�wietl komunikat:
            } catch (InputMismatchException ime) {
                //ime.printStackTrace();
                System.err.println("Z�e dane wej�ciowe! Wprowad� liczb�!");
                skaner.nextLine();
                System.out.println("Wprowad� dane ponownie");

            }

        } while (isNotCorrect);




    }
}
