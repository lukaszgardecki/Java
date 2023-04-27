package wzorce.proxy.posrednikWirtualny;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PośrednikObrazków implements Icon {
    private ImageIcon imageIcon;
    private URL obrazekURL;
    private Thread pobieranieThread;
    private boolean pobieranie = false;

    public PośrednikObrazków(URL url) {
        obrazekURL = url;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (imageIcon != null) {
            imageIcon.paintIcon(c, g, x, y);
        } else {
            g.drawString("Trwa ładownia okładki, proszę czekać...", x+300, y+300);
            if (!pobieranie) {
                pobieranie = true;
                pobieranieThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            imageIcon = new ImageIcon(obrazekURL, "Okładka CD");
                            c.repaint();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                pobieranieThread.start();
            }
        }
    }

    @Override
    public int getIconWidth() {
        if (imageIcon != null) return imageIcon.getIconWidth();
        else return 800;
    }

    @Override
    public int getIconHeight() {
        if (imageIcon != null) return imageIcon.getIconHeight();
        else return 600;
    }
}
