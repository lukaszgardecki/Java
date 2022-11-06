package Zad_32_HurtowniaMotoryzacyjna;

class ExhaustPart extends Part {
    private boolean isCompatibleEU;

    public ExhaustPart(int id, String producer, String model, String series, boolean isCompatibleEU) {
        super(id, producer, model, series);
        this.isCompatibleEU = isCompatibleEU;
    }

    public boolean isCompatibleEU() {
        return isCompatibleEU;
    }

    public void setCompatibleEU(boolean compatibleEU) {
        isCompatibleEU = compatibleEU;
    }

    @Override
    public String toString() {
        return super.toString() + ", isCompatibleEU=" + isCompatibleEU;
    }
}
