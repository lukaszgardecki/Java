package methodChaining;

public class MetchodChaining_Main {
    public static void main(String[] args) {

        String name = "tekst";

//        name = name.concat(" zwyk�y");
//        name = name.toUpperCase();
//        name = name.trim();

        name = name.concat(" zwyk�y")
                .toUpperCase()
                .trim();

        System.out.println(name);
    }
}
