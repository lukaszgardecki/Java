package program.settings;

import program.elements.panels.MainPanel;
import program.elements.panels.views.AddOrRemoveView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static program.elements.panels.views.MainView.*;

public class KeyPress implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ENTER) {
            if (MainPanel.mainView.isVisible()) {
                check.doClick();
            } else if (MainPanel.addRemoveView.isVisible()) {
                String t1 = AddOrRemoveView.tf1.getText();
                String t2 = AddOrRemoveView.tf2.getText();
                boolean isNotEmptyT1 = !t1.isBlank() && !t1.equals("wpisz s³ówko");
                boolean isNotEmptyT2 = !t2.isBlank() && !t2.equals("wpisz t³umaczenie");
                if (isNotEmptyT1 && isNotEmptyT2) {
                    AddOrRemoveView.addBtn.doClick();
                } else if (isNotEmptyT1) {
                    AddOrRemoveView.tf2.requestFocusInWindow();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
