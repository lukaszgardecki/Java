package app.comparator;

import app.Player;

import java.util.Comparator;

public class NicknameComparatorAsc implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return p1.getNickname().compareTo(p2.getNickname());
    }
}
