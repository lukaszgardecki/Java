package pl.am.oop.interfejsy;

import java.util.Comparator;

public class MasaComparator implements Comparator<Kot> {

    @Override
    public int compare(Kot kot1, Kot kot2) {
        return Double.compare(kot1.getMasa(), kot2.getMasa());
    }
}
