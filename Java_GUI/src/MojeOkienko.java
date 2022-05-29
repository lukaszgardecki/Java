import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MojeOkienko extends JFrame implements ActionListener {

        //¿eby nasze guziki by³y widoczne w addActionListener, musimy najpierw zadeklarowaæ odpowiednie pola:
        //Czyli bêdziemy mieæ taki guziki o takich nazwach:
        JButton bPodajDate, bWyjscie;



    public MojeOkienko() {
        //ustawiamy rozmiar okienka:
        setSize(300, 200);
        //ustawiamy tytu³ okienka:
        setTitle("Moje pierwsze okienko");
        //menad¿er rozk³adu
        setLayout(null);

        //Tworzymy nowy obiekt (nowy przycisk):
        bPodajDate = new JButton("Podaj datê");
        //przyciskowi musimy nadaæ lokalizacjê i rozmiary, pierwsze dwa argumenty to lokalizacja, a kolejne dwa to rozmiary przycisku, odpowiednio szerokoœæ i wysokoœæ:
        bPodajDate.setBounds(50,50,100,20);
        // teraz trzeba fizycznie dodaæ ten przycisk do okienka:
        add(bPodajDate);
        //bPodajDate(ogólnie przycisk) jest Ÿród³em zdarzeñ, a s³uchaczem zdarzeñ bêdzie nasza ramka
        //¿eby przycisk coœ robi³ musimy zaimplementowaæ do klasy ActionListener
        bPodajDate.addActionListener(this); // <-- "this" bo s³uchaczem zdarzeñ jest nasza ramka

        //Tworzymy drugi przycisk
        bWyjscie = new JButton("Wyjœcie");
        bWyjscie.setBounds(150, 50, 100, 20);
        add(bWyjscie);
        bWyjscie.addActionListener(this);
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
        Object zrodlo = e.getSource();

        if (zrodlo == bPodajDate) {
            System.out.println(new Date());
        } else if (zrodlo == bWyjscie) {
            dispose(); //<-- je¿eli chcemy wyjœc to po prostu dajemy komende dispose()
        }

    }
}
