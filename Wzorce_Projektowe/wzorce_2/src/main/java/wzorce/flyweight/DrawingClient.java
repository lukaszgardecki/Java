package wzorce.flyweight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serial;

public class DrawingClient extends JFrame {
    @Serial
    private static final long serialVersionUID = -13453424534532342L;
    private static final ShapeFactory.ShapeType[] shapes = {
            ShapeFactory.ShapeType.LINE,
            ShapeFactory.ShapeType.OVAL_FILL,
            ShapeFactory.ShapeType.OVAL_NOFILL
    };
    private static final Color[] colors = {
            Color.RED,
            Color.GREEN
    };
    private final int WIDTH;
    private final int HEIGHT;

    public DrawingClient(int width, int height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        Container contentPane = getContentPane();

        JButton startButton = new JButton("Draw");
        JPanel panel = new JPanel();

        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(startButton, BorderLayout.SOUTH);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        startButton.addActionListener(e -> {
            Graphics g = panel.getGraphics();




        });
    }


}
