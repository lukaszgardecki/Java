class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        // write your code here
        String temp1;
        int age;
        temp1 = p1.name;
        p1.name = p2.name;
        p2.name = temp1;

        age = p1.age;
        p1.age = p2.age;
        p2.age = age;
    }
}