import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stats extends JPanel implements ActionListener {
    public Stats() {
        setBounds(0,0, 684, 361);
        setBackground(MyColor.BLUE);
        setLayout(null);

        Button backBtn = new Button("WRÓÆ");
        backBtn.setBounds(550,20, 110, 30);
        backBtn.setActionCommand("back");
        backBtn.addActionListener(this);
        backBtn.setBackground(MyColor.ORANGE_LIGHT);
        backBtn.setFocusPainted(false);
        add(backBtn);


        StatsField statContent = new StatsField();
        add(statContent);


        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String a = e.getActionCommand();

        if(a.equals("back")) {
            Content.view.setVisible(true);
            Content.st.setVisible(false);
        }
    }
}
