package wzorce.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ZdalnyImpl extends UnicastRemoteObject implements Zdalny {
    @Override
    public String powiedzHej() {
        return "Serwer mówi HEJ.";
    }

    public ZdalnyImpl() throws RemoteException {}

    public static void main(String[] args) {
        try {
            Zdalny usługa = new ZdalnyImpl();
            Naming.rebind("ZdalneHej", usługa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
