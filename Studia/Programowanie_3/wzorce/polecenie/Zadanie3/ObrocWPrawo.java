package wzorce.polecenie.Zadanie3;

public class ObrocWPrawo implements Polecenie {
    private final Robot robot;

    ObrocWPrawo(Robot robot) {
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
