import javax.swing.*;

public class Window extends JFrame {
    public Window() {
        setSize(700, 300);
        setTitle("Learn English");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new Content());

        setVisible(true);
    }


}
