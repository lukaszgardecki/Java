package program;

import program.elements.panels.views.AddOrRemoveView;

import java.util.List;
import java.util.Objects;

import static program.elements.panels.views.AddOrRemoveView.groupsCombo;
import static program.elements.panels.views.AddOrRemoveView.levelCombo;

public class MemoBox {
    private final Group group0, group1, group2, group3, group4, group5, group6;
    private int currentGroup = 0;
    private int counter = 0;


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

    public boolean checkIfWordExists() {
        String polishWord = AddOrRemoveView.tf1.getText();
        String englishWord = AddOrRemoveView.tf2.getText();
        String category = String.valueOf(groupsCombo.getSelectedItem());
        String CAT = Category.getCAT(category);
        String level = Objects.requireNonNull(levelCombo.getSelectedItem()).toString();

        boolean ans = false;
        loop:
        for (Group group : this.getAllGroups()) {
            for (String[] word : group) {
                if (word[6].equals(polishWord) && word[7].equals(englishWord) &&
                    word[2].equals(CAT) && word[3].equals(level)
                ) {
                    ans = true;
                    System.out.println("istnieje w memoboxie");
                    break loop;
                }
            }
        }
        return ans;
    }


    public int getNumberOfGroup() {
        int numOfGroup = -1;

        if (!isEmpty()) {
//            System.out.println("curr: " + currentGroup);
//            System.out.println("counter: " + counter);

//            if (group0.isTheOnlyNonEmptyGroup()) numOfGroup = 0;
//            else if (group5.isTheOnlyNonEmptyGroup()) numOfGroup = 5;
//            else if (group4.isTheOnlyNonEmptyGroup()) numOfGroup = 4;
//            else if (group3.isTheOnlyNonEmptyGroup()) numOfGroup = 3;
//            else if (group2.isTheOnlyNonEmptyGroup())  numOfGroup = 2;
//            else if (group1.isTheOnlyNonEmptyGroup())  numOfGroup = 1;



            if (counter > 0) {
                numOfGroup = currentGroup;

                System.out.printf("g:%s counter:%s (zerowa pusta i counter > 0)\n", numOfGroup, counter);
                counter--;
            }

            else if (currentGroup != 0 && counter > getGroup(currentGroup).getMinSize()) {
                numOfGroup = currentGroup;
                counter--;
                System.out.printf("g:%s counter:%s (albo zerowa pe³na, albo coutner = 0)\n", numOfGroup, counter);
            } else {

                if (group0.isTheOnlyNonEmptyGroup()) numOfGroup = 0;
                   else if (group5.isTheOnlyNonEmptyGroup()) numOfGroup = 5;
                   else if (group4.isTheOnlyNonEmptyGroup()) numOfGroup = 4;
                   else if (group3.isTheOnlyNonEmptyGroup()) numOfGroup = 3;
                   else if (group2.isTheOnlyNonEmptyGroup())  numOfGroup = 2;
                   else if (group1.isTheOnlyNonEmptyGroup())  numOfGroup = 1;

                if (group5.isOverloaded()) {
                    numOfGroup = 5;
                    counter = group5.size() - group5.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (overLoad)\n", numOfGroup, counter);
                }
                else if (group4.isOverloaded()) {
                    numOfGroup = 4;
                    counter = group4.size() - group4.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (overLoad)\n", numOfGroup, counter);
                }
                else if (group3.isOverloaded()) {
                    numOfGroup = 3;
                    counter = group3.size() - group3.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (overLoad)\n", numOfGroup, counter);
                }
                else if (group2.isOverloaded()) {
                    numOfGroup = 2;
                    counter = group2.size() - group2.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (overLoad)\n", numOfGroup, counter);
                }
                else if (group1.isOverloaded()) {
                    numOfGroup = 1;
                    counter = group1.size() - group1.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (overLoad)\n", numOfGroup, counter);
                }


                else if (group5.isFull()) {
                    numOfGroup = 5;
                    counter = group5.size() - group5.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (full)\n", numOfGroup, counter);
                }
                else if (group4.isFull()) {
                    numOfGroup = 4;
                    counter = group4.size() - group4.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (full)\n", numOfGroup, counter);
                }
                else if (group3.isFull()) {
                    numOfGroup = 3;
                    counter = group3.size() - group3.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (full)\n", numOfGroup, counter);
                }
                else if (group2.isFull()) {
                    numOfGroup = 2;
                    counter = group2.size() - group2.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (full)\n", numOfGroup, counter);
                }
                else if (group1.isFull()) {
                    numOfGroup = 1;
                    counter = group1.size() - group1.getMinSize();
                    counter--;
                    System.out.printf("g:%s counter:%s (full)\n", numOfGroup, counter);
                }

                //counter--;
                //System.out.println("if3:");

                else if (!group0.isEmpty()) {
//
                    if (group1.isLessThanFull() && group2.isLessThanFull() && group3.isLessThanFull() &&
                        group4.isLessThanFull() && group5.isLessThanFull()
                    ) numOfGroup = 0;

                    //System.out.println("if4:");
                    System.out.printf("g:%s counter:%s (!group0.isEmpty())\n", numOfGroup, counter);

                } else {

                    if (group1.isLessThanFull() && group2.isLessThanFull() && group3.isLessThanFull() &&
                            group4.isLessThanFull() && group5.isLessThanFull()) {
//                        counter = 5;
//                        counter--;
                        if (group5.hasTheHighestLoad()) numOfGroup = 5;
                        else if (group4.hasTheHighestLoad()) numOfGroup = 4;
                        else if (group3.hasTheHighestLoad()) numOfGroup = 3;
                        else if (group2.hasTheHighestLoad()) numOfGroup = 2;
                        else if (group1.hasTheHighestLoad()) numOfGroup = 1;
                    }

                    if (getGroup(numOfGroup).size() > 5) {
                        counter = 5;
                        counter--;
                    } else {
                        counter = getGroup(numOfGroup).size();
                        counter--;
                    }



                    System.out.printf("g:%s counter:%s (zerowa pusta)\n", numOfGroup, counter);
                    //System.out.println("if5:");
                }
            }
            currentGroup = numOfGroup;

        } else {
            System.out.println("MemoBox jest pusty!");
        }
















//       if (!isEmpty()) {
//           if (group0.isTheOnlyNonEmptyGroup()) numOfGroup = 0;
//           else if (group5.isTheOnlyNonEmptyGroup()) numOfGroup = 5;
//           else if (group4.isTheOnlyNonEmptyGroup()) numOfGroup = 4;
//           else if (group3.isTheOnlyNonEmptyGroup()) numOfGroup = 3;
//           else if (group2.isTheOnlyNonEmptyGroup())  numOfGroup = 2;
//
//           else if (group5.isFull() && group5.hasTheHighestLoad()) numOfGroup = 5;
//           else if (group4.isFull() && group4.hasTheHighestLoad()) numOfGroup = 4;
//           else if (group3.isFull() && group3.hasTheHighestLoad()) numOfGroup = 3;
//           else if (group2.isFull() && group2.hasTheHighestLoad()) numOfGroup = 2;
//           else if (group1.isFull() && group1.hasTheHighestLoad()) numOfGroup = 1;
//
//           else if (!group0.isEmpty() &&
//                   (group1.isMoreThanMinimum() || group1.isEmpty()) &&
//                   group2.isLessThanFull() && group3.isLessThanFull() &&
//                   group4.isLessThanFull() && group5.isLessThanFull()
//           ) numOfGroup = 0;
//
//
//
//           else if (group5.isMoreThanMinimum() && group5.hasTheHighestLoad()) numOfGroup = 5;
//           else if (group4.isMoreThanMinimum() && group4.hasTheHighestLoad()) numOfGroup = 4;
//           else if (group3.isMoreThanMinimum() && group3.hasTheHighestLoad()) numOfGroup = 3;
//           else if (group2.isMoreThanMinimum() && group2.hasTheHighestLoad()) numOfGroup = 2;
//           else if (group1.isMoreThanMinimum() && group1.hasTheHighestLoad()) numOfGroup = 1;
//
//           else if (group5.isMoreThanMinimum()) numOfGroup = 5;
//           else if (group4.isMoreThanMinimum()) numOfGroup = 4;
//           else if (group3.isMoreThanMinimum()) numOfGroup = 3;
//           else if (group2.isMoreThanMinimum()) numOfGroup = 2;
//
//
//           else if (group5.isMinimum() || group5.hasTheHighestLoad()) numOfGroup = 5;
//           else if (group4.isMinimum() || group4.hasTheHighestLoad()) numOfGroup = 4;
//           else if (group3.isMinimum() || group3.hasTheHighestLoad()) numOfGroup = 3;
//           else if (group2.isMinimum() || group2.hasTheHighestLoad()) numOfGroup = 2;
//
//           System.out.println("pierwszy wybór grupy: " + numOfGroup);


//
//           /**
//            * Za³o¿enia:
//            * - je¿eli w grupach 2-5 jest wiêcej ni¿ minimum, to odpowiadaj tak d³ugo, a¿
//            *      zostanie uzyskana liczba minimum
//            *
//            * - grupa 1: je¿eli jest osi¹gniête maximum, które wynosi np. 5 to odpowiadaj 5 razy.
//            * - grupa 1: je¿eli jest osi¹gniête maximum, to odpowiadaj "maximum" razy
//            *
//            */
//
//           //je¿eli wybra³ grupê 1
//           if (numOfGroup == 1) {
//
//               //i wczeœniej by³a te¿ wziêta grupa 1
//               if (currentGroup == 1) {
//                   //ale nie skoñczyliœmy odpowiadaæ
//                   if (counter > 0) {
//                       //to wybierz jeszcze raz grupê 1
//                       numOfGroup = 1;
//                       counter--;
//                   }
//               }
//
//               //ale wczeœniej nie dokoñczy³ poprzedniej grupy
//               else if (currentGroup != 0 && getGroup(currentGroup).isMoreThanMinimum()) {
//                   // to wróæ do tej grupy
//                   numOfGroup = currentGroup;
//               }
//
//
//               //a wczeœniej by³a inna grupa ni¿ 1 (tzn. ¿e w jeden jest max lub wiêcej, lub ma najwiêksze zape³nienie)
//               else {
//                   counter = group1.size();
//                   numOfGroup = 1;
//                   currentGroup = 1;
//                   counter--;
//               }
//
//           }
//
//           //je¿eli wybra³ grupê 0,2-5
//           else {
//                // i poprzednia grupa by³a 1
//               if (currentGroup == 1) {
//                   //której nie skoñczyliœmy
//                   if (counter > 0) {
//                       // to wybierz grupê 1
//                       numOfGroup = 1;
//                       counter--;
//                   }
//
//                   //a jeœli skoñczyliœmy
//                   else{
//                       //to nic nie rób
//                   }
//               }
//
//                // i poprzedni¹ grup¹ by³a grupa 2-5, której nie dokoñæzy³
//               else {
//                   if (currentGroup != 0 && getGroup(currentGroup).isMoreThanMinimum()) {
//                       //to dokoñcz tê grupê
//                       numOfGroup = currentGroup;
//                       //currentGroup jest ju¿ ustawione
//                   }
//               }


//               //je¿eli grupa 0 jest pusta
//               if (group0.isEmpty()) {
//
//                   //i counter jest wiêkszy od zera
//                   if (counter > 0) {
//                       numOfGroup = currentGroup;
//                       counter--;
//                   }
//
//                   //i we wszystkich grupach jest minimum lub mniej
//                   else if ((group2.isMinimum() || group2.isLessThanMinimum()) &&
//                           (group3.isMinimum() || group3.isLessThanMinimum()) &&
//                           (group4.isMinimum() || group4.isLessThanMinimum()) &&
//                           (group5.isMinimum() || group5.isLessThanMinimum())) {
//
//                       // to weŸ grupê z najwiêkszym zape³nieniem
//                       if (group5.hasTheHighestLoad()) numOfGroup = 5;
//                       else if (group4.hasTheHighestLoad()) numOfGroup = 4;
//                       else if (group3.hasTheHighestLoad()) numOfGroup = 3;
//                       else if (group2.hasTheHighestLoad()) numOfGroup = 2;
//
//                       //ustaw counter na wielkoœæ tej grupy
//                       counter = 5;
//                   }
//
//
//               }


//
////
////
////           }
////           currentGroup = numOfGroup;
//       }


        System.out.println("wybór grupy: " + numOfGroup);

        return numOfGroup;
    }








    public int getNumOfCurrentGroup() {
        return currentGroup;
    }

    public void setCurrentGroup(int currentGroup) {
        this.currentGroup = currentGroup;
    }

    public Group getCurrentGroup() {
        return this.getGroup(currentGroup);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }




    public Group getGroup0() {
        return group0;
    }

    public Group getGroup6() {
        return group6;
    }

    public String[] getCurrentWord() {
        //System.out.println("currentword to:" + currentGroup);
        if (this.isEmpty()) return Main.displayEmptyBaseMessage();
        return this.getGroup(currentGroup).getFirst();
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
