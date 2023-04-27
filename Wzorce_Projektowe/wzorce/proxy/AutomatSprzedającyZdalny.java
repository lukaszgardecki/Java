package wzorce.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AutomatSprzedającyZdalny extends Remote {
    int pobierzLiczbęGum() throws RemoteException;
    String pobierzLokalizacja() throws RemoteException;
    Stan pobierzStan() throws RemoteException;
}
