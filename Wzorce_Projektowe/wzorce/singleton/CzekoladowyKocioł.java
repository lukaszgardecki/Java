package wzorce.singleton;

public class CzekoladowyKocioł {
    private boolean pusty;
    private boolean ugotowany;
    private volatile static CzekoladowyKocioł czekoladowyKocioł;

    // pusty prywatny konstruktor, w tym przypadku ustawia tylko flagi
    private CzekoladowyKocioł() {
        pusty = true;
        ugotowany = false;
    }

    public static synchronized CzekoladowyKocioł getInstance() {

        // występuje tutaj metoda podwójnego blokowania
        if (czekoladowyKocioł == null) {
            //jeżeli instacja nie została utworzona wcześniej, dopiero wtedy uruchamiany synchronizację
            // zapobiega to sytuacji, w której dwa wątki mogłyby jednocześnie utworzyć ten sam obiekt
            synchronized (CzekoladowyKocioł.class) {
                if (czekoladowyKocioł == null) {
                    czekoladowyKocioł = new CzekoladowyKocioł();
                }
            }
        }
        return czekoladowyKocioł;
    }



    //jakieś metody klasy:

    public void napełniaj() {
        if (jestPusty()) {
            pusty = false;
            ugotowany = false;
        }
    }

    public void opróżniaj() {
        if (!jestPusty() && jestUgotowany()) {
            pusty = true;
        }
    }

    public void gotuj() {
        if (!jestPusty() && !jestUgotowany()) {
            ugotowany = true;
        }
    }


    public boolean jestPusty() {
        return pusty;
    }

    public boolean jestUgotowany() {
        return ugotowany;
    }
}
