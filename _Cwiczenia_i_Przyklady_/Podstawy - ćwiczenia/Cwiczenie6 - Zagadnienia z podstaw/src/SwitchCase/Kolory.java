package SwitchCase;

public class Kolory {
    public static void main(String[] args) {
        String kolor = "CZERWONY";

//      Zapis spos�b 1:
//        switch (kolor) {
//            case "CZERWONY":
//                System.out.println("Kolor czerwony.");
//                break;
//            case "NIEBIESKI":
//                System.out.println("Kolor niebieski.");
//                break;
//            case "ZIELONY":
//                System.out.println("Kolor zielony.");
//                break;
//            default:
//                System.out.println("Inny kolor.");
//                break;
//        }

        //ten sam zapis, spos�b 2, nie trzeba pisa� breaka:
        switch (kolor) {
            case "CZERWONY" -> System.out.println("Kolor czerwony.");
            case "NIEBIESKI" -> System.out.println("Kolor niebieski.");
            case "ZIELONY" -> System.out.println("Kolor zielony.");
            default -> System.out.println("Inny kolor.");
        }
    }
}
