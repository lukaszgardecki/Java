package wzorce.behawioralne.polecenie.Zadanie3;

public class IdzDoPrzodu implements Polecenie {
    private final Robot robot;

    IdzDoPrzodu(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void wykonaj() {
        robot.idzDoPrzodu();
    }

    @Override
    public void cofnij() {
        robot.idzDoTylu();
    }
}
