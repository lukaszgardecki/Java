package wzorce.behawioralne.polecenie.Zadanie3;

public class ObrocWLewo implements Polecenie {
    private final Robot robot;

    ObrocWLewo(Robot robot) {
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
