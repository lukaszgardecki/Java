import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MojeOkienko extends JFrame implements ActionListener {

        //�eby nasze guziki by�y widoczne w addActionListener, musimy najpierw zadeklarowa� odpowiednie pola:
        //Czyli b�dziemy mie� taki guziki o takich nazwach:
        JButton bPodajDate, bWyjscie;



    public MojeOkienko() {
        //ustawiamy rozmiar okienka:
        setSize(300, 200);
        //ustawiamy tytu� okienka:
        setTitle("Moje pierwsze okienko");
        //menad�er rozk�adu
        setLayout(null);

        //Tworzymy nowy obiekt (nowy przycisk):
        bPodajDate = new JButton("Podaj dat�");
        //przyciskowi musimy nada� lokalizacj� i rozmiary, pierwsze dwa argumenty to lokalizacja, a kolejne dwa to rozmiary przycisku, odpowiednio szeroko�� i wysoko��:
        bPodajDate.setBounds(50,50,100,20);
        // teraz trzeba fizycznie doda� ten przycisk do okienka:
        add(bPodajDate);
        //bPodajDate(og�lnie przycisk) jest �r�d�em zdarze�, a s�uchaczem zdarze� b�dzie nasza ramka
        //�eby przycisk co� robi� musimy zaimplementowa� do klasy ActionListener
        bPodajDate.addActionListener(this); // <-- "this" bo s�uchaczem zdarze� jest nasza ramka

        //Tworzymy drugi przycisk
        bWyjscie = new JButton("Wyj�cie");
        bWyjscie.setBounds(150, 50, 100, 20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);
    }

    public static void main(String[] args) {
        //Tworzymy nowy obiekt okno:
        MojeOkienko okno = new MojeOkienko();
        //to okno po naci�ni�ciu X ma si� zamkn��
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setVisible(true);
    }

    //musimy zaimplementowa� metod� i wpisa� w niej co ma si� sta� po naci�ni�ciu przycisku:
    @Override
    public void actionPerformed(ActionEvent e) {
        Object zrodlo = e.getSource();

        if (zrodlo == bPodajDate) {
            System.out.println(new Date());
        } else if (zrodlo == bWyjscie) {
            dispose(); //<-- je�eli chcemy wyj�c to po prostu dajemy komende dispose()
        }

    }
}
