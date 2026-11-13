package wzorce.behawioralne.polecenie.Zadanie3.polecenia;

import wzorce.behawioralne.polecenie.Zadanie3.Robot;

public class PodniesPrzedmiot implements Polecenie {
    private final Robot robot;

    public PodniesPrzedmiot(Robot robot) {
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
