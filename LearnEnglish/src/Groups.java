import java.util.ArrayList;

public enum Groups {
    ZERO(new ArrayList<>()),
    FIRST( new ArrayList<>()),
    SECOND(new ArrayList<>()),
    THIRD(new ArrayList<>()),
    FOURTH(new ArrayList<>()),
    FIFTH(new ArrayList<>());

    ArrayList<String[]> list;
    int size;

    Groups(ArrayList<String[]> list) {
        this.list = list;
        this.size = list.size();
    }

    public static void createMap() {
        Main.map.put(0, Groups.ZERO.getList());
        Main.map.put(1, Groups.FIRST.getList());
        Main.map.put(2, Groups.SECOND.getList());
        Main.map.put(3, Groups.THIRD.getList());
        Main.map.put(4, Groups.FOURTH.getList());
        Main.map.put(5, Groups.FIFTH.getList());
    }

    public ArrayList<String[]> getList() {
        return list;
    }

    public int getSize() {
        return size;
    }


}
