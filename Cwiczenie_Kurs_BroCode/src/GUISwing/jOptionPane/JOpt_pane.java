package GUISwing.jOptionPane;

import javax.swing.*;

public class JOpt_pane {
    public static void main(String[] args) {

        //JOptionPane.showMessageDialog(null, "To jest zwyk³a wiadomoœæi na bank tego nie przeczytasz", "TYTU£", JOptionPane.PLAIN_MESSAGE);
        //JOptionPane.showMessageDialog(null, "To jest informacja", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Czy lubisz pierogi?", "Zapytanie za milion", JOptionPane.QUESTION_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Twój komputer zosta³ zaka¿ony koronawirusem!", "Ostrze¿enie!", JOptionPane.WARNING_MESSAGE);
        //JOptionPane.showMessageDialog(null, "Autodestrukcja!", "Errooooooooor!", JOptionPane.ERROR_MESSAGE);

        //int answer = JOptionPane.showConfirmDialog(null, "Czy lubisz placuchy?", "Ale nie k³am!", JOptionPane.YES_NO_CANCEL_OPTION);

        //String name = JOptionPane.showInputDialog("Jak ciê zw¹?");

        String[] odpowiedzi = {"noo dobra...", "no i?", "idê w pizdu"};

        JOptionPane.showOptionDialog(
                null,
                "Tak na serio nie lubiê tych placków...",
                "Tajna wiadomoœæ!",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                odpowiedzi,
                0);





    }
}
