package program;

import java.util.LinkedList;

public class Group extends LinkedList<String[]> {
    private int maxSize;
    private int minSize;

    Group() {};

    Group(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
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

    public boolean isMoreThanMinimum() {
        return this.size() > minSize;
    }

    public boolean isFull() {
        return this.size() == maxSize;
    }

    public boolean isLessThanFull() {
        return this.size() < maxSize;
    }

    public boolean isOverloaded() {
        return this.size() > maxSize;
    }

    public double getLoadInPercent() {
        return (double) this.size() / maxSize;
    }


    public void addElem(int num) {
        for (int i = 0; i < num; i++) {
            this.add(new String[0]);
        }
    }
}
