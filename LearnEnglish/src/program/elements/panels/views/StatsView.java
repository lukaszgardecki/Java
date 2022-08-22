package program.elements.panels.views;

import program.elements.panels.Content;
import program.elements.panels.MainPanel;

import java.awt.event.ActionEvent;

public class StatsView extends MainPanel {
    public StatsView() {

        StatsField statContent = new StatsField();
        add(statContent);

        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();

        if(a.equals("back")) {
            Content.main.setVisible(true);
            Content.stats.setVisible(false);
        }
    }
}
