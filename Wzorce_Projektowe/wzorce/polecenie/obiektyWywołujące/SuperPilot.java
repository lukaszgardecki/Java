package wzorce.polecenie.obiektyWywołujące;

import wzorce.polecenie.polecenia.BrakPolecenia;
import wzorce.polecenie.polecenia.Polecenie;

import java.util.Stack;

/**
 * Zarządza zestawem obiektów-poleceń, po jednym na każdy przycisk pilota.
 * Kiedy dany przycisk zostanie naciśnięty, wywoływana jest odpowiadająca mu
 * metoda wciśniętoPrzyciskxxx(), która z kolei wywołuje metodę wykonaj()
 * obiektu-polecenia związanego z danym przyciskiem. To jest cały zakres
 * wiedzy, jaką posiada pilot o wywoływanych klasach; dzieje się tak dlatego,
 * że obiekt-polecenie usuwa sprzężenie pomiędzy pilotem a klasami
 * sterującymi poszczególnymi urządzeniami gospodarstwa domowego.
 */
public class SuperPilot {
    private Polecenie[] poleceniaWłącz;
    private Polecenie[] poleceniaWyłącz;
    private Stack<Polecenie> poleceniaWycofaj;
    private int ilośćSlotówWPilocie = 7;

    public SuperPilot() {
        poleceniaWłącz = new Polecenie[ilośćSlotówWPilocie];
        poleceniaWyłącz = new Polecenie[ilośćSlotówWPilocie];

        Polecenie brakPolecenia = new BrakPolecenia();
        for (int i = 0; i < ilośćSlotówWPilocie; i++) {
            poleceniaWłącz[i] = brakPolecenia;
            poleceniaWyłącz[i] = brakPolecenia;
        }
        poleceniaWycofaj = new Stack<>();
    }

    public void ustawPolecenie(int slot, Polecenie polecenieWłącz, Polecenie polecenieWyłącz) {
        poleceniaWłącz[slot] = polecenieWłącz;
        poleceniaWyłącz[slot] = polecenieWyłącz;
    }

    public void wciśniętoPrzyciskWłącz(int slot) {
        poleceniaWłącz[slot].wykonaj();
        poleceniaWycofaj.push(poleceniaWłącz[slot]);
    }

    public void wciśniętoPrzyciskWyłącz(int slot) {
        poleceniaWyłącz[slot].wykonaj();
        poleceniaWycofaj.push(poleceniaWyłącz[slot]);
    }

    public void wciśniętoPrzyciskWycofaj() {
        poleceniaWycofaj.pop().wycofaj();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n------ SuperPilot ------\n");
        for (int i = 0; i < poleceniaWłącz.length; i++) {
            sb.append("[slot %s] %s    %s\n".formatted(i, poleceniaWłącz[i].getClass().getSimpleName(), poleceniaWyłącz[i].getClass().getSimpleName()));
        }
        return sb.toString();
    }
}
