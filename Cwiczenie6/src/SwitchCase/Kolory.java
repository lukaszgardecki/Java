package SwitchCase;

public class Kolory {
    public static void main(String[] args) {
        String kolor = "CZERWONY";

//      Zapis sposób 1:
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

        //ten sam zapis, sposób 2, nie trzeba pisaæ breaka:
        switch (kolor) {
            case "CZERWONY" -> System.out.println("Kolor czerwony.");
            case "NIEBIESKI" -> System.out.println("Kolor niebieski.");
            case "ZIELONY" -> System.out.println("Kolor zielony.");
            default -> System.out.println("Inny kolor.");
        }
    }
}
