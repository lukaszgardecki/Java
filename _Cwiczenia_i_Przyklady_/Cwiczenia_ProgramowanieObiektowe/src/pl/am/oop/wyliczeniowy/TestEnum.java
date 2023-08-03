package pl.am.oop.wyliczeniowy;

import java.util.Arrays;

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Rasa.KUNDEL == Rasa.MOPS);
        System.out.println(Rasa.KUNDEL == Rasa.KUNDEL);
        System.out.println(Rasa.KUNDEL.equals(Rasa.KUNDEL));

        System.out.println(Arrays.toString(Rasa.values()));

        System.out.println(Rasa.OWCZAREK.ordinal());
        System.out.println(Rasa.MOPS.ordinal());
        System.out.println(Rasa.BULDOG.ordinal());
        System.out.println(Rasa.KUNDEL.ordinal());

        System.out.println(Rasa.OWCZAREK.getPelnaNazwa());
    }
}
