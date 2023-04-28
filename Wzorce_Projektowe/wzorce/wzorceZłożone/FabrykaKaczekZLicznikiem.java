package wzorce.wzorceZłożone;

public class FabrykaKaczekZLicznikiem extends AbstrakcyjnaFabrykaKaczek{
    @Override
    public Kwacząca utwórzDzikaKaczka() {
        return new KwakLicznik(new DzikaKaczka());
    }

    @Override
    public Kwacząca utwórzPłaskonosKaczka() {
        return new KwakLicznik(new PłaskonosKaczka());
    }

    @Override
    public Kwacząca utwórzWabikKaczka() {
        return new KwakLicznik(new WabikKaczka());
    }

    @Override
    public Kwacząca utwórzGumowaKaczka() {
        return new KwakLicznik(new GumowaKaczka());
    }

    @Override
    public Kwacząca utwórzGęśKaczka() {
        return new KwakLicznik(new GęśAdapter(new Gęś()));
    }
}
