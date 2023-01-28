package program;

import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Category {
    CAT1("Charakter i osobowo��", new LinkedList<>(), new JCheckBox()),
    CAT2("Czas", new LinkedList<>(), new JCheckBox()),
    CAT3("Cz�ci cia�a", new LinkedList<>(), new JCheckBox()),
    CAT4("Dom", new LinkedList<>(), new JCheckBox()),
    CAT5("D�wi�ki", new LinkedList<>(), new JCheckBox()),
    CAT6("Ekologia", new LinkedList<>(), new JCheckBox()),
    CAT7("Finanse", new LinkedList<>(), new JCheckBox()),
    CAT8("Gospodarka", new LinkedList<>(), new JCheckBox()),
    CAT9("Higiena", new LinkedList<>(), new JCheckBox()),
    CAT10("Kalendarz", new LinkedList<>(), new JCheckBox()),

    CAT11("Kolory", new LinkedList<>(), new JCheckBox()),
    CAT12("Kraje, narodowo�ci, j�zyki", new LinkedList<>(), new JCheckBox()),
    CAT13("Kszta�ty", new LinkedList<>(), new JCheckBox()),
    CAT14("Kultura i sztuka", new LinkedList<>(), new JCheckBox()),
    CAT15("Liczby", new LinkedList<>(), new JCheckBox()),
    CAT16("Media i komunikacja", new LinkedList<>(), new JCheckBox()),
    CAT17("Miary", new LinkedList<>(), new JCheckBox()),
    CAT18("Miasto", new LinkedList<>(), new JCheckBox()),
    CAT19("Moda i ubi�r", new LinkedList<>(), new JCheckBox()),
    CAT20("Mowa i porozumiewanie si�", new LinkedList<>(), new JCheckBox()),

    CAT21("Natura", new LinkedList<>(), new JCheckBox()),
    CAT22("Nauka i edukacja", new LinkedList<>(), new JCheckBox()),
    CAT23("Od�ywianie", new LinkedList<>(), new JCheckBox()),
    CAT24("Opinie", new LinkedList<>(), new JCheckBox()),
    CAT25("Osoba", new LinkedList<>(), new JCheckBox()),
    CAT26("Pa�stwo", new LinkedList<>(), new JCheckBox()),
    CAT27("Podr�e", new LinkedList<>(), new JCheckBox()),
    CAT28("Pogoda", new LinkedList<>(), new JCheckBox()),
    CAT29("Polityka", new LinkedList<>(), new JCheckBox()),
    CAT30("Praca", new LinkedList<>(), new JCheckBox()),

    CAT31("Prawo", new LinkedList<>(), new JCheckBox()),
    CAT32("Problemy spo�eczne", new LinkedList<>(), new JCheckBox()),
    CAT33("Przedmioty", new LinkedList<>(), new JCheckBox()),
    CAT34("Religia", new LinkedList<>(), new JCheckBox()),
    CAT35("Rodzina", new LinkedList<>(), new JCheckBox()),
    CAT36("Ro�liny", new LinkedList<>(), new JCheckBox()),
    CAT37("Ruch i po�o�enie", new LinkedList<>(), new JCheckBox()),
    CAT38("Sport i czas wolny", new LinkedList<>(), new JCheckBox()),
    CAT39("Substancje i materia�y", new LinkedList<>(), new JCheckBox()),
    CAT40("�wiat fantazji", new LinkedList<>(), new JCheckBox()),

    CAT41("Transport", new LinkedList<>(), new JCheckBox()),
    CAT42("Uczucia", new LinkedList<>(), new JCheckBox()),
    CAT43("Urz�d", new LinkedList<>(), new JCheckBox()),
    CAT44("Wie�", new LinkedList<>(), new JCheckBox()),
    CAT45("Wojny i katastrofy", new LinkedList<>(), new JCheckBox()),
    CAT46("Wygl�d", new LinkedList<>(), new JCheckBox()),
    CAT47("Zakupy i us�ugi", new LinkedList<>(), new JCheckBox()),
    CAT48("Zdrowie", new LinkedList<>(), new JCheckBox()),
    CAT49("Zwierz�ta", new LinkedList<>(), new JCheckBox()),
    CAT50("�ycie codzienne", new LinkedList<>(), new JCheckBox()),

    CAT51("Inne", new LinkedList<>(), new JCheckBox());


    private String name;
    private List<String[]> listOfWords;
    private JCheckBox checkBox;

    Category(String name, List<String[]> listOfWords, JCheckBox checkBox) {
        this.name = name;
        this.listOfWords = listOfWords;
        this.checkBox = checkBox;
    }

    public String getName() {
        return name;
    }

    public static String getCAT(String name) {
        String CAT ="";
        for (Category a : values()) {
            if (a.getName().equals(name)) {
                CAT = a.name();
            }
        }
        return CAT;
    }

    public static String getName(String polish, String english) {
        String name = "";
        loop:
        for (Category cat : values()) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polish) && word[7].equals(english)) {
                    name = cat.getName();
                    break loop;
                }
            }
        }
        return name;
    }

    public static String getLevel(String polish, String english) {
        String level = "";
        loop:
        for (Category cat : values()) {
            for (String[] word : cat.getList()) {
                if (word[6].equals(polish) && word[7].equals(english)) {
                    level = word[3];
                    break loop;
                }
            }
        }
        return level;
    }



    public List<String[]> getList() {
        return listOfWords;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }


}
