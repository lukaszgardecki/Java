package wzorce.proxy;

import java.rmi.RemoteException;

public class AutomatSprzedającyMonitor {
    AutomatSprzedającyZdalny automat;

    public AutomatSprzedającyMonitor(AutomatSprzedającyZdalny automat) {
        this.automat = automat;
    }

    public void raport() {
        try {
            System.out.println("Autoamat sprzedający: " + automat.pobierzLokalizacja());
            System.out.println("Towar: " + automat.pobierzLiczbęGum() + " szt.");
            System.out.println("Bieżący stan urządzenia: " + automat.pobierzStan());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
