package wzorce.behawioralne.polecenie.Zadanie3.polecenia;

import wzorce.behawioralne.polecenie.Zadanie3.Robot;

public class IdzDoPrzodu implements Polecenie {
    private final Robot robot;

    public IdzDoPrzodu(Robot robot) {
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
