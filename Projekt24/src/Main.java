import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Wstawiając ścieżkę do lokalizacji folderu itp należy wpisywać NIE jeden slash "\" tylko DWA, czyli dwa razy więcej!. Np jeżeli w ścieżce występują dwa slashe "\\" to poniżej do nawiasu wpisujemy cztery "\\\\" !!!!!!!

        File f = new File("plik.txt");

        //pętla która utworzy plik. Jeżeli plik nie istnieje !f.exists() to wtedy go utwórz:
        if (!f.exists()) {
            try {
                f.createNewFile(); //podkreślone bo kod może zwracać wyjątki dlatego NALEŻY to umieść w try-catch

                //jeżeli plik zostanie utrworzony to niech użytkownik wie o tym:
                System.out.println("Plik został utworzony!");
            } catch (Exception e) {
                //jeżeli wyjątek nastąpi to nich zostanie wyświetlona wiadomość
                System.out.println(e.getMessage());
            }
        }
        //sprawdzimy czy plik jest w stanie zapisu, czy jest w stanie zpaisywać
        if (f.canWrite()) {
            try {
                FileWriter fw = new FileWriter(f, true); //generuje wyjątek dlatego nalezy go umieścić w try-catch
                Formatter fm = new Formatter(fw);


                //skaner do zczytywania info z pliku
                Scanner sf = new Scanner(f);

                //skaner do zczytywania danych z konsoli
                Scanner sc = new Scanner(System.in);

                //od użytkownika będziemy pobierać Stringa
                System.out.println("Podaj tekst do pliku:");
                String tekst = sc.nextLine();

                //zapis do pliku
                fm.format("%s \r\n", tekst);
                System.out.println("Zapisano!");

                //zamykanie pliku
                fm.close();
                fw.close();

                //odczytywanie informacji czy zapis się powiódł
                System.out.println("\nZawartość pliku:");
                while (sf.hasNextLine()) {
                    System.out.println(sf.nextLine());
                }
                sc.close();
                sf.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
