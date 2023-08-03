package serialization;

import java.io.Serializable;

class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String address;

    /**
     * Je¿eli u¿ywamy serializacji i nie chcemy czegoœ serializowaæ nale¿y u¿yæ s³owa "transient"
     * wtedy nawet jeœli ta wartoœæ zostanie ustawiona, to nie zostanie poddana serializacji, tzn. ogólnie obiekt zostanie przes³any ale wartoœci z kluczem "transient" NIE. W ten sposób mo¿emy ochroniæ pewne dane przed serializacj¹
     */
    transient int x; // ta zmienna posiada klucz "transient" - nie chcemy jej przesy³aæ dalej

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student name is " + name +
                ", age is " + age +
                ", address is " + address;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
