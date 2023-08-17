package wzorce.wzorceZłożone;

public class FabrykaKaczek extends AbstrakcyjnaFabrykaKaczek {
    @Override
    public Kwacząca utwórzDzikaKaczka() {
        return new DzikaKaczka();
    }

    @Override
    public Kwacząca utwórzPłaskonosKaczka() {
        return new PłaskonosKaczka();
    }

    @Override
    public Kwacząca utwórzWabikKaczka() {
        return new WabikKaczka();
    }

    @Override
    public Kwacząca utwórzGumowaKaczka() {
        return new GumowaKaczka();
    }

    @Override
    public Kwacząca utwórzGęśKaczka() {
        return new GęśAdapter(new Gęś());
    }
}
