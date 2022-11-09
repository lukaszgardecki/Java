package Zad_45_ZapisyNaZawody;

import java.util.InputMismatchException;
import java.util.Scanner;

class CompetitionController {
    private Scanner scanner = new Scanner(System.in);

    void run() {
        Competition competition = createCompetition();
        fillParticipantsInfo(competition);
        printCompetition(competition);
    }

    private Competition createCompetition() {
        System.out.println("Podaj nazwê zawodów:");
        String competitionName = scanner.nextLine();
        int maxParticipants;
        int ageLimit;
        while(true) {
            try {
                System.out.println("Podaj maksymaln¹ liczbê uczestników:");
                maxParticipants = scanner.nextInt();
                if (maxParticipants <= 0)
                    throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.err.println("WprowadŸ liczbê wiêksz¹ od zera!");
                scanner.nextLine();
            }
        }
        while(true) {
            try {
                System.out.println("Podaj ograniczenie wiekowe:");
                ageLimit = scanner.nextInt();
                if (ageLimit <= 0)
                    throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.err.println("WprowadŸ liczbê wiêksz¹ od zera!");
                scanner.nextLine();
            }
        }

        scanner.nextLine();
        return new Competition(competitionName, maxParticipants, ageLimit);
    }

    private void fillParticipantsInfo(Competition competition) {
        while (competition.hasFreeSpots()) {
            System.out.println("Dodaj nowego uczestnika");
            Participant participant = createParticipant();
            competition.addParticipant(participant);
        }
    }

    private Participant createParticipant() {
        System.out.println("Podaj imiê:");
        String firstName = scanner.nextLine();
        System.out.println("Podaj nazwisko:");
        String lastName = scanner.nextLine();
        System.out.println("Podaj id (np. pesel):");
        String id = scanner.nextLine();
        int age;
        while(true) {
            try {
                System.out.println("Podaj wiek:");
                age = scanner.nextInt();
                if (age <= 0)
                    throw new InputMismatchException();
                break;
            } catch (InputMismatchException e) {
                System.err.println("Wiek musi byæ liczb¹ dodatni¹!");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        return new Participant(firstName, lastName, id, age);
    }

    private void printCompetition(Competition competition) {
        System.out.println(competition.toString());
    }

}
