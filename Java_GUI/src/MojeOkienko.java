import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MojeOkienko extends JFrame implements ActionListener {
    public MojeOkienko() {
        //ustawiamy rozmiar:
        setSize(300, 200);
        //ustawiamy tytu�:
        setTitle("Moje pierwsze okienko");
        //menad�er rozk�adu
        setLayout(null);
        //Wstawimy przycisk:
        JButton bPodajDate = new JButton("Podaj dat�");
        //przyciskowi musimy nada� lokalizacj� i rozmiary, pierwsze dwa argumenty to lokalizacja, a kolejne dwa to rozmiary przycisku, odpowiednio szeroko�� i wysoko��:
        bPodajDate.setBounds(100,50,100,20);
        //button jest �r�d�em zdarze�, a s�uchaczem zdarze� b�dzie nasza ramka
        add(bPodajDate);
        //�eby przycisk co� robi� musimy zaimplementowa� do klasy ActionListener
        bPodajDate.addActionListener(this); // <-- "this" bo s�uchaczem zdarze� jest nasza ramka


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
        System.out.println(new Date());
    }
}
