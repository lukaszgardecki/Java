package wzorce.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Zdalny extends Remote {
    String powiedzHej() throws RemoteException;
}
