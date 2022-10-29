package Zad_21_Winda;

class ElevatorTest {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        elevator.add(new Person(75));
        elevator.add(new Person(55));
        elevator.add(new Person(56));
        elevator.add(new Person(229));


        elevator.start();
    }
}
