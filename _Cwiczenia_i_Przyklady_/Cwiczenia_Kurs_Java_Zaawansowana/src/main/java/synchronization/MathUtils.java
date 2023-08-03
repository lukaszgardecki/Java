package synchronization;

class MathUtils {

    /**
     *  Je¿eli dwa w¹tki wykonuj¹ tê sam¹ metodê, bêd¹ j¹ wykonywaæ w przypadkowej kolejnoœci.
     *  Mo¿emy ustawiæ synchronizacjê wykonywania, tak aby kolejny w¹tek zacz¹³ wykonywaæ metodê
     *  dopiero, gdy pierwszy skoñczy.
     *  ¯eby to zrobiæ mo¿emy przed nazw¹ tej metody dodaæ s³owo "synchronized",
     *
     *      synchronized void getMultiples(int n) {...}
     *
     *  lub wewn¹trz metody mo¿emy umieœciæ fragment kodu w bloku, który bêdzie synchronizowany
     *  i oznaczyæ "synchronzied (this):
     *
     *      synchronized (this) {...}
     */

    void getMultiples(int n) {

        synchronized (this) {
            //dwa w¹tki wykonuj¹ tê sam¹ metodê
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
