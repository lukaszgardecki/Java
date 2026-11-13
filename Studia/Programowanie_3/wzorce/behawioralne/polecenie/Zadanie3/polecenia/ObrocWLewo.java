package wzorce.behawioralne.polecenie.Zadanie3.polecenia;

import wzorce.behawioralne.polecenie.Zadanie3.Robot;

public class ObrocWLewo implements Polecenie {
    private final Robot robot;

    public ObrocWLewo(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void wykonaj() {
        robot.obrocWLewo();
    }

    @Override
    public void cofnij() {
        robot.obrocWPrawo();
    }
}
