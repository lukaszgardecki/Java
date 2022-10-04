package game;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;

public class ScoreTimePanel extends JPanel {

    int horizontalMargin = BoardButtonsPanel.horizontalMargin;
    int verticalMargin = BoardButtonsPanel.verticalMargin;

    int scoreTimePanelWidth = BoardButtonsPanel.boardPanelWidth;
    static int scoreTimePanelHeight = 50;

    BevelBorder myBorder = new BevelBorder(BevelBorder.LOWERED, Color.white, new Color(129, 129, 129));
    static int remainingBombs = Game.getBombs();
    JLabel timerLabel;
    static Timer timer;
    static long lastTickTime;
    JLabel bombLabel;
    static JLabel bombCounter;
    ImageIcon bombIcon = FieldLabel.bombIcon;


    ScoreTimePanel() {
        setBounds(horizontalMargin, verticalMargin, scoreTimePanelWidth, scoreTimePanelHeight);
        //setBackground(new Color(190, 190, 190));
        setBackground(Color.orange);
        setBorder(BorderFactory.createCompoundBorder(myBorder, null));
        setLayout(null);

        timerLabel = new JLabel(String.format("%02d:%02d", 0, 0));
        timerLabel.setFont(new Font("Courier", Font.BOLD, 25));
        timerLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        timerLabel.setSize(100, scoreTimePanelHeight);
        timerLabel.setLocation((scoreTimePanelWidth-timerLabel.getWidth())/2, 0);

        bombLabel = new JLabel();
        bombLabel.setIcon(bombIcon);
        bombLabel.setSize(bombIcon.getIconWidth(), bombIcon.getIconHeight());
        bombLabel.setLocation(10, (scoreTimePanelHeight - bombIcon.getIconHeight())/2);

        bombCounter = new JLabel();
        bombCounter.setText(String.valueOf(remainingBombs));
        bombCounter.setSize(bombIcon.getIconWidth(), bombIcon.getIconHeight());
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

        add(timerLabel);
        add(bombLabel);
        add(bombCounter);
    }



    public static void startTimer() {
        lastTickTime = System.currentTimeMillis();
        timer.start();
    }

    public void setScoreTimePanelWidth(int width) {
        scoreTimePanelWidth = width;
    }
}
