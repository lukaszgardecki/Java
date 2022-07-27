package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class AI {
    Random random = new Random();



    public void makeMove() {
        int freeFields = Board.countFreeFields();
        ArrayList<String> freeFieldsList = new ArrayList<>(freeFields);
        int aiChoice = random.nextInt(freeFields);

        //dodaj wspó³rzêdne wolnych pól do listy
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Board.table[i][j].equals(Board.getSignEmpty())) {
                    String cords = "" + (i+1) + (j+1);
                    freeFieldsList.add(cords);
                }
            }
        }
        String choice = freeFieldsList.get(aiChoice);

        int cor1 = Integer.parseInt(String.valueOf(choice.charAt(0)));
        int cor2 = Integer.parseInt(String.valueOf(choice.charAt(1)));

        //insert sign
        Message.display(8);
        Board.insertSign(cor1, cor2);

    }
}
