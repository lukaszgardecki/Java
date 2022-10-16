package program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Group extends LinkedList<String[]> {
    static List<Group> groups1to5 = new ArrayList<>();
    private int maxSize;
    private int minSize;

    Group() {};

    Group(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        groups1to5.add(this);
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public boolean isMinimum() {
        return this.size() == minSize;
    }

    public boolean isLessThanMinimum() {
        return this.size() < minSize;
    }

    public boolean isMoreThanMinimum() {
        return this.size() > minSize;
    }

    public boolean isFull() {
        return this.size() >= maxSize;
    }

    public boolean isLessThanFull() {
        return this.size() < maxSize;
    }

    public double getLoadInPercent() {
        return (double) this.size() / maxSize;
    }


    public void addElem(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new String[0]);
        }
    }

    boolean hasTheHighestLoad() {
        boolean ans = true;
        for (Group group : groups1to5) {
            if (this.getLoadInPercent() < group.getLoadInPercent()) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
