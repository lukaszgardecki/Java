package Zad_55_Generyki;

class Pair <T, V> {
    private T type;
    private V value;

    public Pair(T type, V value) {
        this.type = type;
        this.value = value;
    }

    T getType() {
        return type;
    }

    void setType(T type) {
        this.type = type;
    }

    V getValue() {
        return value;
    }

    void setValue(V value) {
        this.value = value;
    }

    void showInfo() {
        System.out.println("Para sk³ada siê z wartoœci " + type + " i " + value);
    }

}
