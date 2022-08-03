import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] newspaper = scanner.nextLine().split("\\s+");
        String[] note = scanner.nextLine().split("\\s+");

        if (newspaper.length < note.length) {
            System.out.println("You are busted");
            return;
        }
        //dodaj elementy do listy
//        ArrayList<String> list = new ArrayList<>(Arrays.asList(newspaper).subList(0, newspaper.length));


        //System.out.println(list);


        for (int i = 0; i < note.length; i++) {
            for (int j = 0; j < newspaper.length; j++) {
                //boolean areTheSame = list.get(j).equals(note[i]);
                boolean areTheSame = newspaper[j].equals(note[i]);

                if (areTheSame) {
                    //list.remove(list.get(j));
                    newspaper[j] = " ";
                    break;
                }
                //je¿eli ostatni wyraz z listy nie pasuje
                if (j == newspaper.length-1) {
                    System.out.println("You are busted");
                    return;
                }
            }
            //je¿eli wszystkie wyrazy pasuj¹
            if (i == note.length-1) {
                System.out.println("You get money");
            }

        }




    }
}