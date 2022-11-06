package Zad_33_Szkolenia;

class FullTimeCourse extends Course {
    private String city;
    private int numOfClasses;

    public FullTimeCourse(String id, double price, String name, String description, String city, int numOfClasses) {
        super(id, price, name, description);
        this.city = city;
        this.numOfClasses = numOfClasses;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumOfClasses() {
        return numOfClasses;
    }

    public void setNumOfClasses(int numOfClasses) {
        this.numOfClasses = numOfClasses;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", city='" + city + '\'' +
                ", numOfClasses=" + numOfClasses;
    }
}
