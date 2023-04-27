package wzorce.proxy.posrednikWirtualny;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class PośrednikObrazkówTest {
    private ImageComponent imageComponent;
    private JFrame frame = new JFrame("Przeglądarka okładek CD");
    private JMenuBar menuBar;
    private JMenu menu;
    private HashMap<String, String> dyski = new HashMap<>();

    public static void main(String[] args) throws Exception {
        PośrednikObrazkówTest test = new PośrednikObrazkówTest();
    }

    public PośrednikObrazkówTest() throws Exception {
        dyski.put("Boston", "https://m.media-amazon.com/images/I/81oj3-+lutL._SL1500_.jpg");
        dyski.put("Vol. 2-Greatest Hits", "https://m.media-amazon.com/images/I/41LXSoB0keL.jpg");
        dyski.put("If Not For You[Deluxe 2 CD]", "https://m.media-amazon.com/images/I/71hGCh5GN8L._SL1200_.jpg");
        dyski.put("Don't Stop Believin by Olivia Newton-John", "https://m.media-amazon.com/images/I/51RESFgHNFL.jpg");
        dyski.put("Balance Of Power", "https://m.media-amazon.com/images/I/51iZB+LgPQL._SL1500_.jpg");
        dyski.put("The Signature Box", "https://m.media-amazon.com/images/I/41SKIgCiy0L.jpg");

        URL startURL = new URL(dyski.get("The Signature Box"));
        menuBar = new JMenuBar();
        menu = new JMenu("Ulubione CD");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        for (String s : dyski.keySet()) {
            JMenuItem menuItem = new JMenu(s);
            menu.add(menuItem);
            menuItem.addActionListener(e -> {
                imageComponent.setIcon(new PośrednikObrazków(pobierzUrlCD(e.getActionCommand())));
                frame.repaint();
            });
        }

        Icon icon = new PośrednikObrazków(startURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private URL pobierzUrlCD(String nazwa) {
        try {
            return new URL(dyski.get(nazwa));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
