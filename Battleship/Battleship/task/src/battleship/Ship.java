package battleship;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ship {
    private final String name;
    private final int fields;
    private List<String> cords = new ArrayList<>();

    public Ship (String name, int fields) {
        this.name = name;
        this.fields = fields;
    }

    public int getFields() {
        return fields;
    }
    public String getName() {
        return name;
    }
    public List<String> getCords() {
        return cords;
    }

    public void setCords(String cord) {
        this.cords.add(cord);
    }

    public void addCoordsToShipList(Ship sh, String cor1, String cor2, Battlefield OOO) {
        int from1 = OOO.returnCoordinate(cor1);
        int from2 = Integer.parseInt(cor1.substring(1));
        int to1 = OOO.returnCoordinate(cor2);
        int to2 = Integer.parseInt(cor2.substring(1));
        char letterFrom = cor1.charAt(0);
        char letterTo = cor2.charAt(0);
        boolean shipIsHorizontal = from1 == to1;
        boolean shipIsVertical = from2 == to2;

        if(shipIsHorizontal) {
            for (int i = from2; i <= to2; i++) {
                String c = letterFrom + String.valueOf(i);
                sh.setCords(c);
            }
        } else if (shipIsVertical) {
            for (char i = letterFrom; i <= letterTo; i++) {
                String c = i + String.valueOf(from2);
                sh.setCords(c);
            }
        }

    }

    //metoda zwracaj¹ca boolean czy statek jest zatopiony
    public static boolean isShipSunk(String cor, List<List<String>> lst) {
        //zmienna przechowuj¹ca Index uderzonego statku (na wszelki wypadek)
        int indexOfHitShip;
        boolean answer = false;

        for (int i = 0; i < lst.size(); i++) {
            for (int j = 0; j < lst.get(i).size(); j++) {

                String el = lst.get(i).get(j);
                boolean checked = Objects.equals(el, cor);

                if (checked) {
                    indexOfHitShip = i;
                    lst.get(i).remove(el);
                    answer = lst.get(i).isEmpty();
                }
            }
        }
        return answer;
    }


}
