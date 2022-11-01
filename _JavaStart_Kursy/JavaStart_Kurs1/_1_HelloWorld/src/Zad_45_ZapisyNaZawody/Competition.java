package Zad_45_ZapisyNaZawody;

import java.util.Objects;

class Competition {
    private String name;
    private Participant[] participants;
    private int ageLimit;
    private int size;

    public Competition(String name, int maxParticipants, int ageLimit) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.participants = new Participant[maxParticipants];
    }

    void addParticipant(Participant participant) {
        if (participant.getAge() < ageLimit) {
            throw new AgeViolationException("Nie spe³niono kryterium wieku.");
        } else if (!hasFreeSpots()) {
            throw new MaxCompetitorsException("Brak miejsc.");
        } else if (isAlreadyExist(participant)) {
            throw new DuplicateException("Uczestnik ju¿ istnieje w bazie.");
        } else {
            participants[size] = participant;
            size++;
        }
    }

    private boolean isAlreadyExist(Participant participant) {
        for (Participant p : participants) {
            if (p == null) continue;
            if (Objects.equals(participant.getDocumentId(), p.getDocumentId())) return true;
        }
        return false;
    }

    boolean hasFreeSpots() {
        return size < participants.length;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Zawody ")
                .append(name)
                .append("\n")
                .append("Liczba uczestników: ").append(size);
        for (int i = 0; i < size; i++) {
            builder.append("\n");
            builder.append(" > ");
            builder.append(participants[i].toString());
        }
        return builder.toString();
    }
}
