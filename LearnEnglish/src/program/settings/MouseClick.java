package program.settings;

import program.elements.panels.views.AddOrRemoveView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements MouseListener {
    public static String polishWord;
    public static String englishWord;

    @Override
    public void mouseClicked(MouseEvent e) {
        int a = e.getButton();
        if (a == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
            String wholeLine = AddOrRemoveView.list.getSelectedValue();
            polishWord = wholeLine.substring(0, wholeLine.lastIndexOf("(") - 1);
            englishWord = wholeLine.substring(wholeLine.lastIndexOf("(") + 1, wholeLine.lastIndexOf(")"));
            AddOrRemoveView.tf1.setText(polishWord);
            AddOrRemoveView.tf2.setText(englishWord);
            AddOrRemoveView.tf1.setForeground(MyColor.BLACK);
            AddOrRemoveView.tf2.setForeground(MyColor.BLACK);

            AddOrRemoveView.addBtn.setText("ZMIEÑ");
            AddOrRemoveView.addBtn.setBackground(MyColor.YELLOW);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
