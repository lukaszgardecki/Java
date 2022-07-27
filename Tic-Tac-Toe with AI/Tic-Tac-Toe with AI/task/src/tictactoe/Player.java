package tictactoe;

import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);



    public void makeMove() {
        Message.display(1);
        String[] corTab = scanner.nextLine().split(" ");
        int cor1 = Integer.parseInt(corTab[0]);
        int cor2 = Integer.parseInt(corTab[1]);

        //insert sign
        Board.insertSign(cor1, cor2);

    }
}
