import java.util.Stack;

//        -------- STOS ---------
//        Polega na tym, że każdy nastepny element PRZYSŁANIA poprzedni

public class Stos {
    public static void main(String[] args) {
        Stack<String> stos = new Stack<>();

        System.out.println("\n\nStos:");

        //Dodanie elementów do stosu:
        stos.push("Pierwszy");
        stos.push("Drugi");
        stos.push("Trzeci");
        System.out.println(stos.size());

        //Zdejmowanie elementów ze stosu - metoda pop():
        System.out.println(stos.pop());

        //Dodanie elementów do stosu:
        stos.push("Ostatni");

        //Usuwanie (zdejmowanie) elementów ze stosu:
        stos.pop();
        stos.pop();
        stos.pop();

        //Sprawdzenie rozmiaru stosu:
        System.out.println(stos.size());



    }
}
