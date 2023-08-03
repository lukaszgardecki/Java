package pl.am.projects.rownanieKwadratowe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RownanieGUI extends JFrame implements ActionListener {

    private final JTextField tA, tB, tC, tWynik;
    JLabel lA, lB, lC;
    private final JButton bWyjscie, bRozwiaz;

    public RownanieGUI() {
        setSize(700, 400);
        setTitle("Rozwiazywanie równania kwadratowego");
        setLayout(null);

        lA = new JLabel("a =", JLabel.RIGHT);
        lA.setBounds(0, 50, 40, 20);
        add(lA);
        tA = new JTextField();
        tA.setBounds(50, 50, 50, 20);
        tA.setToolTipText("Podaj wspó³czynnik a");
        add(tA);

        lB = new JLabel("b =", JLabel.RIGHT);
        lB.setBounds(100, 50, 40, 20);
        add(lB);
        tB = new JTextField();
        tB.setBounds(150, 50, 50, 20);
        tB.setToolTipText("Podaj wspó³czynnik b");
        add(tB);

        lC = new JLabel("c =", JLabel.RIGHT);
        lC.setBounds(200, 50, 40, 20);
        add(lC);
        tC = new JTextField();
        tC.setToolTipText("Podaj wspó³czynnik c");
        tC.setBounds(250, 50, 50, 20);
        add(tC);

        bRozwiaz = new JButton("Rozwi¹¿ równanie");
        bRozwiaz.setBounds(40,150,140,20);
        bRozwiaz.addActionListener(this);
        add(bRozwiaz);

        bWyjscie = new JButton("Wyjœcie");
        bWyjscie.setBounds(240,150,100,20);
        bWyjscie.addActionListener(this);
        add(bWyjscie);

        tWynik = new JTextField();
        tWynik.setBounds(50, 200, 500, 20);
        add(tWynik);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        if (zrodlo == bWyjscie) {
            dispose();
        } else if (zrodlo == bRozwiaz) {
            int a = Integer.parseInt(tA.getText());
            int b = Integer.parseInt(tB.getText());
            int c = Integer.parseInt(tC.getText());

            RownanieKwadratowe rownanie = new RownanieKwadratowe(a, b, c);
            String rozwiazanie = rownanie.rozwiaz();
            tWynik.setText(rozwiazanie);
        }
    }


    public static void main(String[] args) {
        RownanieGUI app = new RownanieGUI();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }


}
