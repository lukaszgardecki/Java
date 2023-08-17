package wzorce.proxy;

import java.rmi.Naming;

public class ZdalnyKlient {
    public static void main(String[] args) {
        new ZdalnyKlient().go();
    }

    public void go() {
        try {
            Zdalny usługa = (Zdalny) Naming.lookup("rmi:127.0.0.1/ZdalneHej");
            String s = usługa.powiedzHej();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
