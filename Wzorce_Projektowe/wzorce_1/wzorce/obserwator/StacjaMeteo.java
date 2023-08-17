package wzorce.obserwator;

import wzorce.obserwator.obiektObserwowany.DanePogodowe;
import wzorce.obserwator.obserwatorzy.IndeksCiepłaWyświetl;
import wzorce.obserwator.obserwatorzy.PrognozaWyświetl;
import wzorce.obserwator.obserwatorzy.StatystykaWyświetl;
import wzorce.obserwator.obserwatorzy.WarunkiBieżąceWyświetl;

public class StacjaMeteo {
    public static void main(String[] args) {
        DanePogodowe danePogodowe = new DanePogodowe();

        WarunkiBieżąceWyświetl warunkiBieżąceWyświetl = new WarunkiBieżąceWyświetl(danePogodowe);
        StatystykaWyświetl statystykaWyświetl = new StatystykaWyświetl(danePogodowe);
        PrognozaWyświetl prognozaWyświetl = new PrognozaWyświetl(danePogodowe);
        IndeksCiepłaWyświetl indeksCiepłaWyświetl = new IndeksCiepłaWyświetl(danePogodowe);

        danePogodowe.ustawOdczyty(26.6f, 65, 1013.1f);
        danePogodowe.ustawOdczyty(27.7f, 70, 997.0f);
        danePogodowe.ustawOdczyty(25.5f, 90, 997.0f);
    }
}
