package wzorce.proxy;

import java.rmi.Naming;

public class AutomatSprzedającyMonitorTest {

    public static void main(String[] args) {
        String[] lokalizacja = {
                "rmi://gliwice.automatysprzedajace.com/automatsprzedajacy",
                "rmi://wroclaw.automatysprzedajace.com/automatsprzedajacy",
                "rmi://warszawa.automatysprzedajace.com/automatsprzedajacy",
        };

        AutomatSprzedającyMonitor[] monitor = new AutomatSprzedającyMonitor[lokalizacja.length];

        for (int i = 0; i < lokalizacja.length; i++) {
            try {
                AutomatSprzedającyZdalny automat = (AutomatSprzedającyZdalny) Naming.lookup(lokalizacja[i]);
                monitor[i] = new AutomatSprzedającyMonitor(automat);
                System.out.println(monitor[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < monitor.length; i++) {
            monitor[i].raport();
        }
    }
}
