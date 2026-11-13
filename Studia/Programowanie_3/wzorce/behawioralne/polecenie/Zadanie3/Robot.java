package wzorce.behawioralne.polecenie.Zadanie3;

/**
 * Odbiorca (Receiver)
 */
public class Robot {

    public void idzDoPrzodu() {
        System.out.println("Robot idzie do przodu");
    }

    public void idzDoTylu() {
        System.out.println("Robot cofa się");
    }

    public void obrocWLewo() {
        System.out.println("Robot obraca się w lewo");
    }

    public void obrocWPrawo() {
        System.out.println("Robot obraca się w prawo");
    }

    public void podniesPrzedmiot() {
        System.out.println("Robot podnosi przedmiot");
    }

    public void opuscPrzedmiot() {
        System.out.println("Robot opuszcza przedmiot");
    }
}
