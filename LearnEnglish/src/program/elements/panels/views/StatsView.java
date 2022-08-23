package program.elements.panels.views;

import program.elements.panels.Content;
import program.elements.panels.MainPanel;

import java.awt.event.ActionEvent;

public class StatsView extends View {
    public StatsView() {

        StatsField statContent = new StatsField();
        add(statContent);

        setVisible(false);
    }
}
