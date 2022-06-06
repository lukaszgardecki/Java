package object;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;


        //ten if przyczynia si� do tego, �e program nie wy�wietla wszystkich kafelek, tylko te, kt�re widzimy:
        //na pocz�tku do worldX, worldY trzeba doda�/odj�� rozmiar kafelka �eby rysowanie i znikanie odbywa�o si� zaraz za polem naszego okna (�eby nie by�o wida� rysowania)
        if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {

            //rysuj kafelki:
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);

        }

    }

}
