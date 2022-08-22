import javax.swing.*;
import java.awt.*;

public class Content extends JPanel {
    static Stats st;
    static MainView view;

    public Content() {
        setBounds(0, 0, 684, 361);
        //setBackground(Color.ORANGE.darker());
        setLayout(null);

        view = new MainView();
        add(view);

        st = new Stats();
        add(st);


    }
}
