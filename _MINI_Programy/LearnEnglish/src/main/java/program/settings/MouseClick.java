package program.settings;

import program.Category;
import program.elements.panels.views.AddOrRemoveView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements MouseListener {

    private static String wholeLine;

    @Override
    public void mouseClicked(MouseEvent e) {
        int a = e.getButton();
        if (a == MouseEvent.BUTTON1 && e.getClickCount() == 2) {
            wholeLine = getListPosition();

            //wczytaj wartoœci do komponentów
            AddOrRemoveView.tf1.setText(getPolishWord());
            AddOrRemoveView.tf2.setText(getEnglishWord());
            AddOrRemoveView.tf1.setForeground(MyColor.BLACK);
            AddOrRemoveView.tf2.setForeground(MyColor.BLACK);
            AddOrRemoveView.groupsCombo.setSelectedItem(getCategory());
            AddOrRemoveView.levelCombo.setSelectedItem(getLevel());
            AddOrRemoveView.addBtn.setText("ZMIEÑ");
            AddOrRemoveView.addBtn.setBackground(MyColor.YELLOW);

            System.out.printf("po kliku: %s, %s\n", getCategory(), getLevel());
        }
    }

    public static String getListPosition() {
        return AddOrRemoveView.list.getSelectedValue();
    }

    public static String getPolishWord() {
        return wholeLine.substring(0, wholeLine.lastIndexOf("(") - 1);
    }

    public static String getEnglishWord() {
        return wholeLine.substring(wholeLine.lastIndexOf("(") + 1, wholeLine.lastIndexOf(")"));
    }

    public static String getCategory() {
        return Category.getName(getPolishWord(), getEnglishWord());
    }

    public static String getLevel() {
        return Category.getLevel(getPolishWord(), getEnglishWord());
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
