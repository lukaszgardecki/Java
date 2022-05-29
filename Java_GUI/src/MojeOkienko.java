import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MojeOkienko extends JFrame implements ActionListener {
    public MojeOkienko() {
        //ustawiamy rozmiar:
        setSize(300, 200);
        //ustawiamy tytu³:
        setTitle("Moje pierwsze okienko");
        //menad¿er rozk³adu
        setLayout(null);
        //Wstawimy przycisk:
        JButton bPodajDate = new JButton("Podaj datê");
        //przyciskowi musimy nadaæ lokalizacjê i rozmiary, pierwsze dwa argumenty to lokalizacja, a kolejne dwa to rozmiary przycisku, odpowiednio szerokoœæ i wysokoœæ:
        bPodajDate.setBounds(100,50,100,20);
        //button jest Ÿród³em zdarzeñ, a s³uchaczem zdarzeñ bêdzie nasza ramka
        add(bPodajDate);
        //¿eby przycisk coœ robi³ musimy zaimplementowaæ do klasy ActionListener
        bPodajDate.addActionListener(this); // <-- "this" bo s³uchaczem zdarzeñ jest nasza ramka


    }

    public static void main(String[] args) {
        //Tworzymy nowy obiekt okno:
        MojeOkienko okno = new MojeOkienko();
        //to okno po naciœniêciu X ma siê zamkn¹æ
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    //musimy zaimplementowaæ metodê i wpisaæ w niej co ma siê staæ po naciœniêciu przycisku:
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(new Date());
    }
}
