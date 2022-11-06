package Zad_32_HurtowniaMotoryzacyjna;

class Part {
    private int id;
    private String producer;
    private String model;
    private String series;

    public Part(int id, String producer, String model, String series) {
        this.id = id;
        this.producer = producer;
        this.model = model;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " +
                "id=" + id +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", series='" + series + '\'';
    }
}
