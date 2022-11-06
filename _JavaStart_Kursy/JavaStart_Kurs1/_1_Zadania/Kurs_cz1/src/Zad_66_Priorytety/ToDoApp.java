package Zad_66_Priorytety;

import java.util.Scanner;

class ToDoApp {
    private static TaskManager manager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // dodanie pocz�tkowych zada�
        manager.add(new Task("Zakupy", Task.Priority.MODERATE, "Zrobienie zakup�w na nast�pny tydzie�"));
        manager.add(new Task("Samoch�d", Task.Priority.LOW, "Umy�, wyczy�ci�, wypucowa�"));
        manager.add(new Task("Szko�a", Task.Priority.HIGH));

        run();
    }

    private static void run() {
        System.out.println("Witamy w TaskManager!");
        while (true) {
            System.out.println("""
                    Wybierz opcj�:
                    0 - zamknij aplikacj�
                    1 - dodaj nowe zadanie
                    2 - pobierz kolejne zadanie
                """);
            String option = scanner.nextLine();
            switch (option) {
                case "0" -> exit();
                case "1" -> addNewTask();
                case "2" -> getNextTask();
                default -> System.out.println("Wpisz 0, 1 lub 2.");
            }
        }
    }

    private static void getNextTask() {
        Task nextTask = manager.getNextTask();
        if (nextTask == null) {
            System.out.println("Brak zada�.");
            return;
        };

        System.out.println("Nast�pne zadanie to:");
        System.out.println(nextTask);
    }

    private static void addNewTask() {
        manager.add(new Task(getName(), getPriority(), getDesc()));
        System.out.println("Pomy�lnie dodano zadanie.");
    }

    private static String getName() {
        System.out.println("Wpisz nazw� zadania:");
        return scanner.nextLine();
    }

    private static String getDesc() {
        System.out.println("Wpisz opis zadania:");
        return scanner.nextLine();
    }

    private static Task.Priority getPriority() {
        while (true) {
            System.out.printf("Wpisz priorytet zadania [%s]:%n", manager.getTasksPriorityNames());
            String name = scanner.nextLine();
            for (Task.Priority value : Task.Priority.values()) {
                if (value.name().equals(name.toUpperCase())) {
                    return value;
                }
            }
        }

    }

    private static void exit() {
        System.out.println("Zamykanie programu.");
        System.exit(0);
    }
}
