import javax.management.remote.TargetedNotification;

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

//    @Override
//    public int compareTo(Person otherPerson) {
//        // add your code here!
//        int nam = name.compareTo(otherPerson.getName());
//        if (nam == 0) {
//            if (getAge() == otherPerson.getAge()) {
//                return 0;
//            } else if (getAge() < otherPerson.getAge()) {
//                return -1;
//            } else {
//                return 1;
//            }
//        } else if (nam < 0) {
//            return  -1;
//        } else {
//            return 1;
//        }
//    }
@Override
public int compareTo(Person otherPerson) {
    // add your code here!
    int nam = name.compareTo(otherPerson.getName());
    if (nam == 0 && getAge() == otherPerson.getAge()) {
        return 0;
    } else if (nam < 0 && getAge() < otherPerson.getAge()) {
        return -1;
    } else {
        return 1;
    }
}






}