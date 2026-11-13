package wzorce.behawioralne.polecenie.Zadanie5;

/**
 * Odbiorca (Receiver) poleceń
 */
public class Jednostka {

    public void atakuj() {
        System.out.println("Jednostka atakuje!");
    }

    public void wycofaj() {
        System.out.println("Jednostka wycofuje się.");
    }

    public void bronSie() {
        System.out.println("Jednostka broni się!");
    }

    public void przestanBronic() {
        System.out.println("Jednostka przestaje się bronić.");
    }

    public void buduj() {
        System.out.println("Jednostka buduje strukturę.");
    }

    public void rozbierz() {
        System.out.println("Jednostka rozbiera strukturę.");
    }

    public void zbierajSurowce() {
        System.out.println("Jednostka zbiera surowce.");
    }

    public void oddajSurowce() {
        System.out.println("Jednostka oddaje zebrane surowce.");
    }
}
