package GUISwing.jOptionPane;

import javax.swing.*;

public class JOpt_pane {
    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null, "To jest zwyk�a wiadomo��i na bank tego nie przeczytasz", "TYTU�", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "To jest informacja", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Czy lubisz pierogi?", "Zapytanie za milion", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Tw�j komputer zosta� zaka�ony koronawirusem!", "Ostrze�enie!", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Autodestrukcja!", "Errooooooooor!", JOptionPane.ERROR_MESSAGE);

        //int answer = JOptionPane.showConfirmDialog(null, "Czy lubisz placuchy?", "Ale nie k�am!", JOptionPane.YES_NO_CANCEL_OPTION);

        //String name = JOptionPane.showInputDialog("Jak ci� zw�?");

        String[] odpowiedzi = {"noo dobra...", "no i?", "id� w pizdu"};

        JOptionPane.showOptionDialog(
                null,
                "Tak na serio nie lubi� tych plack�w...",
                "Tajna wiadomo��!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                odpowiedzi,
                0);





    }
}
