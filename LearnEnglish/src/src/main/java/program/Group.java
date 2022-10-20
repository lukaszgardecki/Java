package program;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static program.Main.memoBox;

public class Group extends LinkedList<String[]> {
    static List<Group> groups0to6 = new ArrayList<>();
    private int maxSize;
    private int minSize;

    Group() {
        groups0to6.add(this);
    };

    Group(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
        groups0to6.add(this);
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
        return this.size() == maxSize;
    }

    public boolean isOverloaded() {
        return this.size() > maxSize;
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
        for (Group group : groups0to6) {
            if (group.equals(memoBox.getGroup0()) || group.equals(memoBox.getGroup6())) continue;
            if (this.getLoadInPercent() < group.getLoadInPercent()) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    boolean isTheOnlyNonEmptyGroup() {
        boolean ans = true;
        for (Group group : groups0to6) {
            if (group.equals(memoBox.getGroup6()) || group.equals(this)) continue;
            if (!group.isEmpty()) {
                ans = false;
                break;
            }
        }
        return ans;
    }
}
