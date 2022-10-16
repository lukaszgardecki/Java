package program;

import java.util.List;

public class MemoBox {
    private final Group group0, group1, group2, group3, group4, group5, group6;
    private static int currentGroup = 0;
    private static int group1counter = 0;


    public MemoBox(int capOfGroup1, int capOfGroup2, int capOfGroup3, int capOfGroup4, int capOfGroup5) {
        this.group0 = new Group();
        this.group1 = new Group(0, capOfGroup1);
        this.group2 = new Group(capOfGroup2 - capOfGroup1, capOfGroup2);
        this.group3 = new Group(capOfGroup3 - capOfGroup1, capOfGroup3);
        this.group4 = new Group(capOfGroup4 - capOfGroup1, capOfGroup4);
        this.group5 = new Group(capOfGroup5 - capOfGroup1, capOfGroup5);
        this.group6 = new Group();
    }

    public int getCapOfGroup(int group) {
        int cap = 0;
        if (group == 1) cap = group1.getMaxSize();
        else if (group == 2) cap = group2.getMaxSize();
        else if (group == 3) cap = group3.getMaxSize();
        else if (group == 4) cap = group4.getMaxSize();
        else if (group == 5) cap = group5.getMaxSize();
        return cap;
    }

    @Override
    public String toString() {
        return "MemoBox:\n" +
                "group0: vol=" + group0.size() + "\n" +
                "group1: vol=" + group1.size() + " (min=" + group1.getMinSize() + ", max=" + group1.getMaxSize() + ", load=" + group1.getLoadInPercent() + ")\n" +
                "group2: vol=" + group2.size() + " (min=" + group2.getMinSize() + ", max=" + group2.getMaxSize() + ", load=" + group2.getLoadInPercent() + ")\n" +
                "group3: vol=" + group3.size() + " (min=" + group3.getMinSize() + ", max=" + group3.getMaxSize() + ", load=" + group3.getLoadInPercent() + ")\n" +
                "group4: vol=" + group4.size() + " (min=" + group4.getMinSize() + ", max=" + group4.getMaxSize() + ", load=" + group4.getLoadInPercent() + ")\n" +
                "group5: vol=" + group5.size() + " (min=" + group5.getMinSize() + ", max=" + group5.getMaxSize() + ", load=" + group5.getLoadInPercent() + ")\n" +
                "group6: vol=" + group6.size();
    }

    public void add(String[] word) {
        int numOfGroup = Integer.parseInt(word[1]);
        if (numOfGroup == 0) group0.add(word);
        if (numOfGroup == 1) group1.add(word);
        if (numOfGroup == 2) group2.add(word);
        if (numOfGroup == 3) group3.add(word);
        if (numOfGroup == 4) group4.add(word);
        if (numOfGroup == 5) group5.add(word);
        if (numOfGroup == 6) group6.add(word);
    }

    public void remove(String[] word) {
        int numOfGroup = Integer.parseInt(word[1]);
        if (numOfGroup == 0) group0.remove(word);
        if (numOfGroup == 1) group1.remove(word);
        if (numOfGroup == 2) group2.remove(word);
        if (numOfGroup == 3) group3.remove(word);
        if (numOfGroup == 4) group4.remove(word);
        if (numOfGroup == 5) group5.remove(word);
        if (numOfGroup == 6) group6.remove(word);
    }

    public boolean isEmpty() {
        return group0.isEmpty() &&
               group1.isEmpty() &&
               group2.isEmpty() &&
               group3.isEmpty() &&
               group4.isEmpty() &&
               group5.isEmpty();
    }


    public int getNumberOfGroup() {
        int word = -1;

       if (!isEmpty()) {
           if (group1.isEmpty() && group2.isEmpty() && group3.isEmpty() && group4.isEmpty() && group5.isEmpty()) word = 0;
           else if (group0.isEmpty() && group1.isEmpty() && group2.isEmpty() && group3.isEmpty() && group4.isEmpty()) word = 5;
           else if (group0.isEmpty() && group1.isEmpty() && group2.isEmpty() && group3.isEmpty() && group5.isEmpty()) word = 4;
           else if (group0.isEmpty() && group1.isEmpty() && group2.isEmpty() && group4.isEmpty() && group5.isEmpty()) word = 3;
           else if (group0.isEmpty() && group1.isEmpty() && group3.isEmpty() && group4.isEmpty() && group5.isEmpty())  word = 2;

           else if (group5.isFull() && group5.hasTheHighestLoad()) word = 5;
           else if (group4.isFull() && group4.hasTheHighestLoad()) word = 4;
           else if (group3.isFull() && group3.hasTheHighestLoad()) word = 3;
           else if (group2.isFull() && group2.hasTheHighestLoad()) word = 2;
           else if (group1.isFull() && group1.hasTheHighestLoad()) word = 1;

           else if (group1.isMoreThanMinimum() && !group0.isEmpty()) word = 0;

           else if (group5.isMoreThanMinimum() && group5.hasTheHighestLoad()) word = 5;
           else if (group4.isMoreThanMinimum() && group4.hasTheHighestLoad()) word = 4;
           else if (group3.isMoreThanMinimum() && group3.hasTheHighestLoad()) word = 3;
           else if (group2.isMoreThanMinimum() && group2.hasTheHighestLoad()) word = 2;
           else if (group1.isMoreThanMinimum() && group1.hasTheHighestLoad()) word = 1;

           else if (group5.isMoreThanMinimum()) word = 5;
           else if (group4.isMoreThanMinimum()) word = 4;
           else if (group3.isMoreThanMinimum()) word = 3;
           else if (group2.isMoreThanMinimum()) word = 2;

           else if (group5.isMinimum() || group5.hasTheHighestLoad()) word = 5;
           else if (group4.isMinimum() || group4.hasTheHighestLoad()) word = 4;
           else if (group3.isMinimum() || group3.hasTheHighestLoad()) word = 3;
           else if (group2.isMinimum() || group2.hasTheHighestLoad()) word = 2;





           /**
            * Za³o¿enia:
            * - je¿eli w grupach 2-5 jest wiêcej ni¿ minimum, to odpowiadaj tak d³ugo, a¿
            *      zostanie uzyskana liczba minimum
            *
            * - grupa 1: je¿eli jest osi¹gniête maximum, które wynosi np. 5 to odpowiadaj 5 razy.
            * - grupa 1: je¿eli jest osi¹gniête maximum, to odpowiadaj "maximum" razy
            *
            */

           //je¿eli wybra³ grupê 1
           if (word == 1) {
               //i wczeœniej by³a te¿ wziêta grupa 1
               if (currentGroup == 1) {
                   //ale nie skoñczyliœmy odpowiadaæ
                   if (group1counter > 0) {
                       word = 1;
                       group1counter--;
                   }
                //a wczeœniej by³a inna grupa ni¿ 1 (tzn. ¿e w jeden jest max lub wiêcej, lub ma najwiêksze zape³nienie)
               } else {
                   group1counter = group1.size();
                   word = 1;
                   currentGroup = 1;
                   group1counter--;
               }

           }

           //je¿eli wybra³ grupê 0,2-5
           else {

               //ale w poprzedniej grupie jest wiêcej jak minimum to weŸ dokoñcz tamt¹ grupê
               if (currentGroup != 1 && getGroup(currentGroup).isMoreThanMinimum()) {
                   word = currentGroup;
                   //currentGroup jest ju¿ ustawione
               }

           }
           currentGroup = word;
       }
        return word;
    }





    private double getMaxPercent() {
        return Math.max(group1.getLoadInPercent(),
               Math.max(group2.getLoadInPercent(),
               Math.max(group3.getLoadInPercent(),
               Math.max(group4.getLoadInPercent(), group5.getLoadInPercent()))));
    }

    // metoda potrzebna do testu
    public void setGroupSizes(int g0, int g1, int g2, int g3, int g4, int g5) {
        group0.addElem(g0);
        group1.addElem(g1);
        group2.addElem(g2);
        group3.addElem(g3);
        group4.addElem(g4);
        group5.addElem(g5);
    }

    public Group getGroup(int numOfGroup) {
        if (numOfGroup == 1) return group1;
        else if (numOfGroup == 2) return group2;
        else if (numOfGroup == 3) return group3;
        else if (numOfGroup == 4) return group4;
        else if (numOfGroup == 5) return group5;
        else if (numOfGroup == 6) return group6;
        else return group0;
    }

    public List<Group> getAllGroups() {
        return List.of(group0, group1, group2, group3, group4, group5, group6);
    }
}
