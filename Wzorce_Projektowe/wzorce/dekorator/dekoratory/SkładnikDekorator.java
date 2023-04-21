package wzorce.dekorator.dekoratory;

import wzorce.dekorator.składnikiGłówne.Napój;

public abstract class SkładnikDekorator extends Napój {

    public abstract String pobierzOpis();

    public abstract int pobierzWielkość();
}
