package program;

public class MemoBox {
    private final int capOfGroup1;
    private final int capOfGroup2;
    private final int capOfGroup3;
    private final int capOfGroup4;
    private final int capOfGroup5;

    public MemoBox(int capOfGroup1, int capOfGroup2, int capOfGroup3, int capOfGroup4, int capOfGroup5) {
        this.capOfGroup1 = capOfGroup1;
        this.capOfGroup2 = capOfGroup2;
        this.capOfGroup3 = capOfGroup3;
        this.capOfGroup4 = capOfGroup4;
        this.capOfGroup5 = capOfGroup5;
    }

    public int getCapOfGroup(int group) {
        int cap = 0;
        if (group == 1) cap = capOfGroup1;
        else if (group == 2) cap = capOfGroup2;
        else if (group == 3) cap = capOfGroup3;
        else if (group == 4) cap = capOfGroup4;
        else if (group == 5) cap = capOfGroup5;
        return cap;
    }
}
