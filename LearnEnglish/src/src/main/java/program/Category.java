package program;

import java.util.LinkedList;
import java.util.List;

public enum Category {
    CAT1("Charakter i osobowo��", new LinkedList<>()),
    CAT2("Czas", new LinkedList<>()),
    CAT3("Cz�ci cia�a", new LinkedList<>()),
    CAT4("Dom", new LinkedList<>()),
    CAT5("D�wi�ki", new LinkedList<>()),
    CAT6("Ekologia", new LinkedList<>()),
    CAT7("Finanse", new LinkedList<>()),
    CAT8("Gospodarka", new LinkedList<>()),
    CAT9("Higiena", new LinkedList<>()),
    CAT10("Kalendarz", new LinkedList<>()),

    CAT11("Kolory", new LinkedList<>()),
    CAT12("Kraje, narodowo�ci, j�zyki", new LinkedList<>()),
    CAT13("Kszta�ty", new LinkedList<>()),
    CAT14("Kultura i sztuka", new LinkedList<>()),
    CAT15("Liczby", new LinkedList<>()),
    CAT16("Media i komunikacja", new LinkedList<>()),
    CAT17("Miary", new LinkedList<>()),
    CAT18("Miasto", new LinkedList<>()),
    CAT19("Moda i ubi�r", new LinkedList<>()),
    CAT20("Mowa i porozumiewanie si�", new LinkedList<>()),

    CAT21("Natura", new LinkedList<>()),
    CAT22("Nauka i edukacja", new LinkedList<>()),
    CAT23("Od�ywianie", new LinkedList<>()),
    CAT24("Opinie", new LinkedList<>()),
    CAT25("Osoba", new LinkedList<>()),
    CAT26("Pa�stwo", new LinkedList<>()),
    CAT27("Podr�e", new LinkedList<>()),
    CAT28("Pogoda", new LinkedList<>()),
    CAT29("Polityka", new LinkedList<>()),
    CAT30("Praca", new LinkedList<>()),

    CAT31("Prawo", new LinkedList<>()),
    CAT32("Problemy spo�eczne", new LinkedList<>()),
    CAT33("Przedmioty", new LinkedList<>()),
    CAT34("Religia", new LinkedList<>()),
    CAT35("Rodzina", new LinkedList<>()),
    CAT36("Ro�liny", new LinkedList<>()),
    CAT37("Ruch i po�o�enie", new LinkedList<>()),
    CAT38("Sport i czas wolny", new LinkedList<>()),
    CAT39("Substancje i materia�y", new LinkedList<>()),
    CAT40("�wiat fantazji", new LinkedList<>()),

    CAT41("Transport", new LinkedList<>()),
    CAT42("Uczucia", new LinkedList<>()),
    CAT43("Urz�d", new LinkedList<>()),
    CAT44("Wie�", new LinkedList<>()),
    CAT45("Wojny i katastrofy", new LinkedList<>()),
    CAT46("Wygl�d", new LinkedList<>()),
    CAT47("Zakupy i us�ugi", new LinkedList<>()),
    CAT48("Zdrowie", new LinkedList<>()),
    CAT49("Zwierz�ta", new LinkedList<>()),
    CAT50("�ycie codzienne", new LinkedList<>()),

    CAT51("Inne", new LinkedList<>());


    private String name;
    private List<String[]> listOfWords;

    Category(String name, List<String[]> listOfWords) {
        this.name = name;
        this. listOfWords = listOfWords;
    }

    public String getName() {
        return name;
    }

    public List<String[]> getList() {
        return listOfWords;
    }


}
