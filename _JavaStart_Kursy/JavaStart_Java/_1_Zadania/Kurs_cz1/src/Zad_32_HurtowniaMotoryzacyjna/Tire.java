package Zad_32_HurtowniaMotoryzacyjna;

class Tire extends Part {
    private String size;
    private String width;

    public Tire(int id, String producer, String model, String series, String size, String width) {
        super(id, producer, model, series);
        this.size = size;
        this.width = width;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", size='" + size + '\'' +
                ", width='" + width + '\'';
    }
}
