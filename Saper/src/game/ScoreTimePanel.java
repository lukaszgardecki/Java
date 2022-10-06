package game;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

import static game.Main.game;

public class ScoreTimePanel extends JPanel {
    int scoreTimePanelWidth = FieldLabel.getFieldWidth() * game.getGameWidth() + (2 * MainPanel.getMarginX()) - 2 * MainPanel.getMarginX();

    static int scoreTimePanelHeight = 50;
    BevelBorder myBorder = new BevelBorder(BevelBorder.LOWERED, Color.white, new Color(129, 129, 129));
    static int remainingBombs = game.getBombs();
    JLabel timerLabel;
    static Timer timer;
    static long lastTickTime;
    JLabel bombLabel;
    JLabel bombCounter;
    static JButton resetBtn;
    ImageIcon bombIcon = FieldLabel.bombIcon;
    static ImageIcon happy = new ImageIcon("src/game/images/happy.png");
    static ImageIcon shocked = new ImageIcon("src/game/images/shocked.png");
    static ImageIcon dead = new ImageIcon("src/game/images/dead.png");
    static ImageIcon cool = new ImageIcon("src/game/images/cool.png");

    ScoreTimePanel() {
        setBounds(MainPanel.getMarginX(), MainPanel.getMarginY(),
                FieldLabel.getFieldWidth() * game.getGameWidth(), scoreTimePanelHeight);
        setBackground(Color.orange);
        setBorder(BorderFactory.createCompoundBorder(myBorder, null));
        setLayout(null);

        resetBtn = new JButton();
        resetBtn.setSize(40, 40);
        resetBtn.setLocation((FieldLabel.getFieldWidth() * game.getGameWidth()-resetBtn.getWidth())/2,
                                (scoreTimePanelHeight - resetBtn.getHeight())/2);
        resetBtn.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        resetBtn.setIcon(happy);
        resetBtn.setBackground(new Color(2, 58, 112));
        resetBtn.setFocusable(false);
        resetBtn.addActionListener(event -> MainPanel.resetElements());

        timerLabel = new JLabel(String.format("%02d:%02d", 0, 0));
        timerLabel.setFont(new Font("Courier", Font.BOLD, 25));
        timerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        timerLabel.setSize(63, scoreTimePanelHeight);
        timerLabel.setLocation(FieldLabel.getFieldWidth() * game.getGameWidth()-timerLabel.getWidth() - 10, 0);

        bombLabel = new JLabel();
        bombLabel.setIcon(bombIcon);
        bombLabel.setSize(bombIcon.getIconWidth(), bombIcon.getIconHeight());
        bombLabel.setLocation(10, (scoreTimePanelHeight - bombIcon.getIconHeight())/2);

        bombCounter = new JLabel();
        bombCounter.setText(String.valueOf(remainingBombs));
        bombCounter.setSize(50, bombIcon.getIconHeight());
        bombCounter.setLocation(10 + bombIcon.getIconWidth(), (scoreTimePanelHeight - bombIcon.getIconHeight())/2);
        bombCounter.setFont(new Font("Courier", Font.BOLD, 25));

        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long runningTime = System.currentTimeMillis() - lastTickTime;
                Duration duration = Duration.ofMillis(runningTime);
                long hours = duration.toHours();
                duration = duration.minusHours(hours);
                long minutes = duration.toMinutes();
                duration = duration.minusMinutes(minutes);
                long millis = duration.toMillis();
                long seconds = millis / 1000;

                if (hours < 1) {
                    timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
                } else {
                    timerLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
                }
            }
        });
        add(resetBtn);
        add(timerLabel);
        add(bombLabel);
        add(bombCounter);
    }

    void refresh() {
        changeSize();
        resetPanel();
    }

    void resetPanel() {
        timerLabel.setLocation(FieldLabel.getFieldWidth() * game.getGameWidth()-timerLabel.getWidth() - 10, 0);
        resetBtn.setLocation((FieldLabel.getFieldWidth() * game.getGameWidth()-resetBtn.getWidth())/2,
                                (scoreTimePanelHeight - resetBtn.getHeight())/2);
        resetBtn.setIcon(happy);
        timerLabel.setText(String.format("%02d:%02d", 0, 0));
        timer.stop();
        bombCounter.setText(String.valueOf(game.getBombs()));
        setRemainingBombs();
    }

    private void setRemainingBombs() {
        remainingBombs = game.getBombs();
    }

    void changeSize() {
        setBounds(MainPanel.getMarginX(), MainPanel.getMarginY(),
                FieldLabel.getFieldWidth() * game.getGameWidth(),
                getScoreTimePanelHeight());
    }

    public static void startTimer() {
        lastTickTime = System.currentTimeMillis();
        timer.start();
    }

    public static int getScoreTimePanelHeight() {
        return scoreTimePanelHeight;
    }
}
