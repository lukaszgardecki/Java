package Java_poziom_1.Lekcja_9_przetwarzanie_danych_napisy_i_liczby.przyklad_6;

import java.util.StringTokenizer;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

public class Oper1 {
    public static void main(String[] args) {

        String normalQuest = "Liczba1 op Liczba2",
                errorQuest = "Wadliwe dane. Popraw.\n" + normalQuest,
                quest = normalQuest,
                expr = "";

        while ((expr = showInputDialog(quest, expr)) != null) {
            int res;
            try {
                StringTokenizer st = new StringTokenizer(expr);
                int num1 = Integer.parseInt(st.nextToken());
                String sop = st.nextToken();
                int num2 = Integer.parseInt(st.nextToken());

                if (sop.length() != 1 || st.hasMoreTokens())
                    throw new IllegalArgumentException();


                switch (sop.charAt(0)) {
                    case '+' : res = num1 + num2; break;
                    case '-' : res = num1 - num2; break;
                    case '*' : res = num1 * num2; break;
                    case '/' : res = num1 / num2; break;
                    default  : throw new IllegalArgumentException();
                }
            } catch (Exception exc) {
                quest = errorQuest;
                continue;
            }
            showMessageDialog(null, "Wynik = " + res);
            quest = normalQuest;
            expr = "";
        }

    }

}
