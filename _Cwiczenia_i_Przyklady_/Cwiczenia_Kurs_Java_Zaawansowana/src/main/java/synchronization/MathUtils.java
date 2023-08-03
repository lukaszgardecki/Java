package synchronization;

class MathUtils {

    /**
     *  Je�eli dwa w�tki wykonuj� t� sam� metod�, b�d� j� wykonywa� w przypadkowej kolejno�ci.
     *  Mo�emy ustawi� synchronizacj� wykonywania, tak aby kolejny w�tek zacz�� wykonywa� metod�
     *  dopiero, gdy pierwszy sko�czy.
     *  �eby to zrobi� mo�emy przed nazw� tej metody doda� s�owo "synchronized",
     *
     *      synchronized void getMultiples(int n) {...}
     *
     *  lub wewn�trz metody mo�emy umie�ci� fragment kodu w bloku, kt�ry b�dzie synchronizowany
     *  i oznaczy� "synchronzied (this):
     *
     *      synchronized (this) {...}
     */

    void getMultiples(int n) {

        synchronized (this) {
            //dwa w�tki wykonuj� t� sam� metod�
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
