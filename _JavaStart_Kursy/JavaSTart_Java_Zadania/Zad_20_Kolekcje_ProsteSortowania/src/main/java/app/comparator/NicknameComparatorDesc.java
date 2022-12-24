package app.comparator;

import app.Player;

import java.util.Comparator;

public class NicknameComparatorDesc implements Comparator<Player> {

    @Override
    public int compare(Player p1, Player p2) {
        return p2.getNickname().compareTo(p1.getNickname());
    }
}
