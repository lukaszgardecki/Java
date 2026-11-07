package wzorce.polecenie.Zadanie3;

public class PodniesPrzedmiot implements Polecenie {
    private final Robot robot;

    PodniesPrzedmiot(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void wykonaj() {
        robot.podniesPrzedmiot();
    }

    @Override
    public void cofnij() {
        robot.opuscPrzedmiot();
    }
}
