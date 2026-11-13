package wzorce.behawioralne.polecenie.Zadanie3.polecenia;

import wzorce.behawioralne.polecenie.Zadanie3.Robot;

public class ObrocWPrawo implements Polecenie {
    private final Robot robot;

    public ObrocWPrawo(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void wykonaj() {
        robot.obrocWPrawo();
    }

    @Override
    public void cofnij() {
        robot.obrocWLewo();
    }
}
