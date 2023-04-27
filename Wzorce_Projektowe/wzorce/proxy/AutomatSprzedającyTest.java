package wzorce.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class AutomatSprzedającyTest {
    public static void main(String[] args) {
        AutomatSprzedający automatSprzedający = null;
        int liczba;

        if (args.length < 2) {
            System.out.println("AutomatSprzedający <nazwa> <towar>");
            System.exit(1);
        }

        try {
            liczba = Integer.parseInt(args[1]);
            automatSprzedający = new AutomatSprzedający(args[0], liczba);
            Naming.rebind("//" + args[0] + "/automatsprzedajacy", automatSprzedający);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
