package wzorce.adapter.adapter;

public class IndykAadpter implements Kaczka{
    private Indyk indyk;

    public IndykAadpter(Indyk indyk) {
        this.indyk = indyk;
    }

    @Override
    public void kwacz() {
        indyk.gulgocz();
    }

    @Override
    public void lataj() {
        for (int i = 0; i < 5; i++) {
            indyk.lataj();
        }
    }
}
