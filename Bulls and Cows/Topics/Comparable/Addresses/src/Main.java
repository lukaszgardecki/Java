import java.util.*;

class Address implements Comparable<Address> {
    private final String city;
    private final String street;
    private final String house;

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public String getHouse() {
        return house;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "%s, %s, %s".formatted(house, street, city);
    }

    @Override
    public int compareTo(Address o) {
        int h = getHouse().compareTo(o.getHouse());
        int s = getStreet().compareTo(o.getStreet());
        int c = getCity().compareTo(o.getCity());

        if (h == 0 && s == 0 && c == 0) {
            return 0;
        } else if ((h == 0 && s == 0 && c < 0) || (h == 0 && s < 0) || h < 0) {
            return -1;
        } else {
            return 1;
        }

//        if (h == 0) {
//            if (s == 0) {
//                if (c == 0) {
//                    return 0;
//                } else if ( c < 0) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            } else if (s < 0) {
//                return -1;
//            } else {
//                return 1;
//            }
//        } else if (h < 0) {
//            return -1;
//        } else {
//            return 1;
//        }
    }
}

// do not change the code below
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Address> list = new ArrayList<>();

        while (sc.hasNextLine()) {
            String[] arguments = sc.nextLine().split(",");
            list.add(new Address(arguments[0], arguments[1], arguments[2]));
        }
        Collections.sort(list);
        Checker.check(list);
    }
}