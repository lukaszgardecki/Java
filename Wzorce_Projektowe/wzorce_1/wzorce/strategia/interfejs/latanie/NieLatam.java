package wzorce.strategia.interfejs.latanie;

public class NieLatam implements LatanieInterfejs{
    @Override
    public void leć() {
        System.out.println("Nie umiem latać");
    }
}
