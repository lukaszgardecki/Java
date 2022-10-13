package program;

public class MemoBox {
    private final Group group0, group1, group2, group3, group4, group5, group6;


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

    // DO POPRAWY!!!!!!!!!!!!!!!
    public int getWord() {
        int word = -1;

        //jeżeli memobox nie jest pusty
       if (!isEmpty()) {


           //jeżeli grupa 0 jest pusta
           if (group0.isEmpty()) {

               //jeżeli grupa 1 jest pusta
               if (group1.isEmpty()) {

                   //jeżeli grupa 2 jest pusta
                   if (group2.isEmpty()) {

                       //jeżeli grupa 3 jest pusta
                       if (group3.isEmpty()) {



                           //jeżeli grupa 4 jest pusta
                           if (group4.isEmpty()) {
                               //to weź fiszkę z grupy 5, bo tylko tu są fiszki
                               word = 5;
                           }

                           //jeżeli grupa 4 ma fiszki i grupa 5 jest pusta
                           else if (group5.isEmpty()) {
                                   //to weź z grupy 4, bo tylko tu są fiszki
                                   word = 4;
                           }
                               // jeżeli grupa 4 ma fiszki i grupa 5 też ma fiszki
                               else {
                                   //jeżeli obie są TAK SAMO przeładowane
                                   if (group5.isOverloaded() && group4.isOverloaded() &&
                                           group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;

                                   //jeżeli obie są przeładowane ale 4 jst bardziej
                                   else if (group5.isOverloaded() && group4.isOverloaded() &&
                                           group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;

                                   //jeżeli obie są przeładowane ale 5 jst bardziej
                                   else if (group5.isOverloaded() && group4.isOverloaded() &&
                                           group5.getLoadInPercent() > group4.getLoadInPercent())  word = 5;

                                   //jeżeli obie są pełne
                                   else if (group5.isFull() && group4.isFull()) word = 5;

                                   //jeżeli 5 jest pełna
                                   else if (group5.isFull()) word = 5;

                                   //jeżeli 4 jest pełna
                                   else if (group4.isFull()) word = 4;

                                   //jeżeli obie mają więcej niż minimum
                                   else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum()) {

                                       //i takie smao zapełnienie
                                       if (group5.getLoadInPercent() == group4.getLoadInPercent()) {
                                           word = 5;
                                       }
                                       // i 5 ma większe zapłenienie
                                       else if (group5.getLoadInPercent() > group4.getLoadInPercent()) {
                                           word = 5;
                                       }

                                       // i 4 ma większe zapełnienie
                                       else if (group5.getLoadInPercent() < group4.getLoadInPercent()) {
                                           word = 4;
                                       }
                                   }
                                   //jeżeli obie mają równe minimum
                                   else if (group5.isMinimum() && group4.isMinimum()) word = 5;

                                   //jeżeli 5 ma minimum a 4 ma mniej
                                   else if (group5.isMinimum()) word = 5;

                                   //jeżeli 4 ma minimum a 5 ma mniej
                                   else if (group4.isMinimum()) word = 4;

                                   //obie mają mniej niż minimum ale 5 ma więkze zapełnienie
                                   else if (group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;

                                   //obie mają mniej niż minimum ale 4 ma większe zapełnienie
                                   else word = 4;
                               }


                       }

                       //jeżeli grupa 3 ma fiszki
                       else {
                           //i grupy 4 i 5 są puste
                           if (group4.isEmpty() && group5.isEmpty()) {
                               //to weź 3 bo tylko tu są fiszki
                               word = 3;
                           }

                           //jeżeli poza grupą 3 grupa 5 też ma fiszki (jeżeli 4 jest pusta)
                           else if (group4.isEmpty()) {

                               //jeżeli obie są TAK SAMO przeładowane
                               if (group5.isOverloaded() && group3.isOverloaded() &&
                                       group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;

                                   //jeżeli obie są przeładowane ale 3 jst bardziej
                               else if (group5.isOverloaded() && group3.isOverloaded() &&
                                       group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;

                                   //jeżeli obie są przeładowane ale 5 jst bardziej
                               else if (group5.isOverloaded() && group3.isOverloaded() &&
                                       group5.getLoadInPercent() > group3.getLoadInPercent())  word = 5;

                                   //jeżeli obie są pełne
                               else if (group5.isFull() && group3.isFull()) word = 5;

                                   //jeżeli 5 jest pełna
                               else if (group5.isFull()) word = 5;

                                   //jeżeli 3 jest pełna
                               else if (group3.isFull()) word = 3;

                                   //jeżeli obie mają więcej niż minimum
                               else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum()) {

                                   //i takie smao zapełnienie
                                   if (group5.getLoadInPercent() == group3.getLoadInPercent()) {
                                       word = 5;
                                   }
                                   // i 5 ma większe zapłenienie
                                   else if (group5.getLoadInPercent() > group3.getLoadInPercent()) {
                                       word = 5;
                                   }

                                   // i 3 ma większe zapełnienie
                                   else if (group5.getLoadInPercent() < group3.getLoadInPercent()) {
                                       word = 3;
                                   }
                               }
                               //jeżeli obie mają równe minimum
                               else if (group5.isMinimum() && group3.isMinimum()) word = 5;

                                   //jeżeli 5 ma minimum a 3 ma mniej
                               else if (group5.isMinimum()) word = 5;

                                   //jeżeli 3 ma minimum a 5 ma mniej
                               else if (group3.isMinimum()) word = 3;

                                   //obie mają mniej niż minimum ale 5 ma więkze zapełnienie
                               else if (group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;

                                   //obie mają mniej niż minimum ale 3 ma większe zapełnienie
                               else word = 3;







                           }
                           //jeżeli poza grupą 3 grupa 4 też ma fiszki (jeżeli 5 jest pusta)
                           else if (group5.isEmpty()) {
                               //jeżeli obie są TAK SAMO przeładowane
                               if (group3.isOverloaded() && group4.isOverloaded() &&
                                       group3.getLoadInPercent() == group4.getLoadInPercent()) word = 4;

                                   //jeżeli obie są przeładowane ale 4 jst bardziej
                               else if (group3.isOverloaded() && group4.isOverloaded() &&
                                       group3.getLoadInPercent() < group4.getLoadInPercent()) word = 4;

                                   //jeżeli obie są przeładowane ale 3 jst bardziej
                               else if (group3.isOverloaded() && group4.isOverloaded() &&
                                       group3.getLoadInPercent() > group4.getLoadInPercent())  word = 3;

                                   //jeżeli obie są pełne
                               else if (group3.isFull() && group4.isFull()) word = 4;

                                   //jeżeli 3 jest pełna
                               else if (group3.isFull()) word = 3;

                                   //jeżeli 4 jest pełna
                               else if (group4.isFull()) word = 4;

                                   //jeżeli obie mają więcej niż minimum
                               else if (group3.isMoreThanMinimum() && group4.isMoreThanMinimum()) {

                                   //i takie smao zapełnienie
                                   if (group3.getLoadInPercent() == group4.getLoadInPercent()) {
                                       word = 4;
                                   }
                                   // i 3 ma większe zapłenienie
                                   else if (group3.getLoadInPercent() > group4.getLoadInPercent()) {
                                       word = 3;
                                   }

                                   // i 4 ma większe zapełnienie
                                   else if (group3.getLoadInPercent() < group4.getLoadInPercent()) {
                                       word = 4;
                                   }
                               }
                               //jeżeli obie mają równe minimum
                               else if (group3.isMinimum() && group4.isMinimum()) word = 4;

                                   //jeżeli 3 ma minimum a 4 ma mniej
                               else if (group3.isMinimum()) word = 3;

                                   //jeżeli 4 ma minimum a 3 ma mniej
                               else if (group4.isMinimum()) word = 4;

                                   //obie mają mniej niż minimum ale 3 ma więkze zapełnienie
                               else if (group3.getLoadInPercent() > group4.getLoadInPercent()) word = 3;

                                   //obie mają mniej niż minimum ale 4 ma większe zapełnienie
                               else word = 4;
                           }





                           //jeżeli grupy 3,4,5 mają fiszki
                           else {
                                boolean group5and4and3areOveloaded = group5.isOverloaded() && group4.isOverloaded() && group3.isOverloaded();
                                boolean gropu5and4sameLoad = group5.getLoadInPercent() == group4.getLoadInPercent();
                                boolean gropu3and4sameLoad = group3.getLoadInPercent() == group4.getLoadInPercent();
                                boolean group5hasHighestLoadInPercent = (group5.getLoadInPercent() > group4.getLoadInPercent()) && (group5.getLoadInPercent() > group3.getLoadInPercent());
                                boolean group4hasHighestLoadInPercent = (group4.getLoadInPercent() > group5.getLoadInPercent()) && (group4.getLoadInPercent() > group3.getLoadInPercent());
                                boolean group3hasHighestLoadInPercent = (group3.getLoadInPercent() > group5.getLoadInPercent()) && (group3.getLoadInPercent() > group4.getLoadInPercent());

                               //jeżeli wszystkie są TAK SAMO przeładowane
                               if (group5and4and3areOveloaded && (gropu5and4sameLoad && gropu3and4sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                               else if (group5and4and3areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                               else if (group5and4and3areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                               else if (group5and4and3areOveloaded && group3hasHighestLoadInPercent) word = 3;


                               //jeżeli 5 i 4 są TAK SAMO przeładowane
                               else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 5 bardziej
                               else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 4 bardziej
                               else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;


                               //jeżeli 5 i 3 są TAK SAMO przeładowane
                               else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 5 bardziej
                               else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 4 bardziej
                               else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;


                               //jeżeli 4 i 3 są TAK SAMO przeładowane
                               else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 4 bardziej
                               else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 3 bardziej
                               else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;


                               //jeżeli przeładowana jest tylko 5
                               else if (group5.isOverloaded()) word = 5;
                               //jeżeli przeładowana jest tylko 4
                               else if (group4.isOverloaded()) word = 4;
                               //jeżeli przeładowana jest tylko 3
                               else if (group3.isOverloaded()) word = 3;


                               //jeżęli wszystkie 3 są pełne
                               else if (group5.isFull() && group4.isFull() && group3.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 4
                               else if (group5.isFull() && group4.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 3
                               else if (group5.isFull() && group3.isFull()) word = 5;
                               //jeżeli pełne są tylko 4 i 3
                               else if (group4.isFull() && group3.isFull()) word = 4;
                               //jeżeli pełna jest tylko 5
                               else if (group5.isFull()) word = 5;
                               //jeżeli pełna jest tylko 4
                               else if (group4.isFull()) word = 4;
                               //jeżeli pełna jest tylko 3
                               else if (group3.isFull()) word = 3;


                               //jeżeli wszystkie 3 mają wiecej niż minimum
                               else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                                   //i takie samo zapełnienie
                                   if (gropu5and4sameLoad && gropu3and4sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                                   else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 4 ma największe zapełnienie
                                   else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 3 ma największe zapełnienie
                                   else if (group3hasHighestLoadInPercent) word = 3;
                               }

                               //jeżeli 5 i 4 mają więcej niż minimum
                               else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum()) {
                                   //i takie samo zapełnienie
                                   if (group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                                   else if (group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                                   // i 4 ma największe zapełnienie
                                   else if (group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;
                               }


                               //jeżeli 5 i 3 mają więcej niż minimum
                               else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                                   //i takie samo zapełnienie
                                   if (group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                                       // i 5 ma największe zapełnienie
                                   else if (group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;
                                       // i 4 ma największe zapełnienie
                                   else if (group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                               }


                               //jeżeli 4 i 3 mają więcej niż minimum
                               else if (group4.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                                   //i takie samo zapełnienie
                                   if (group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                                   else if (group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                                   // i 3 ma największe zapełnienie
                                   else if (group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                               }


                               //jeżeli tylko 5 ma więcej niż minimum
                               else if (group5.isMoreThanMinimum()) word = 5;
                               //jeżeli tylko 4 ma więcej niż minimum
                               else if (group4.isMoreThanMinimum()) word = 4;
                               //jeżeli tylko 3 ma więcej niż minimum
                               else if (group3.isMoreThanMinimum()) word = 3;


                               //jeżeli wszystkie 3 mają równe minimum
                               else if (group5.isMinimum() && group4.isMinimum() && group3.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 4 mają równe minimum
                               else if (group5.isMinimum() && group4.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 3 mają równe minimum
                               else if (group5.isMinimum() && group3.isMinimum()) word = 5;
                               //jeżeli tylko 4 i 3 mają równe minimum
                               else if (group4.isMinimum() && group3.isMinimum()) word = 4;


                               //jeżeli 5 ma minimum
                               else if (group5.isMinimum()) word = 5;
                               //jeżeli 4 ma minimum
                               else if (group4.isMinimum()) word = 4;
                               //jeżeli 3 ma minimum
                               else if (group3.isMinimum()) word = 3;


                               //jeżeli wszystkie mają mniej niż minimum
                               // ale 5 ma największe zapełneinie
                               else if (group5hasHighestLoadInPercent) word = 5;
                               // ale 4 ma największe zapełneinie
                               else if (group4hasHighestLoadInPercent) word = 4;
                               // ale 3 ma największe zapełneinie
                               else if (group3hasHighestLoadInPercent) word = 3;

                           }
                       }
                   }

                   //jeżeli grupa 2 ma fiszki
                   else {
                       //i grupy 3, 4 i 5 są puste
                       if (group3.isEmpty() && group4.isEmpty() && group5.isEmpty()) {
                           //to weź 2 bo tylko tu są fiszki
                           word = 2;
                       }

                       //jeżeli poza grupą 2 grupa 3 też ma fiszki (jeżeli 4 i 5 są puste)
                       else if (group4.isEmpty() && group5.isEmpty()) {

                            //jeżeli obie są TAK SAMO przeładowane
                           if (group2.isOverloaded() && group3.isOverloaded() &&
                                   group2.getLoadInPercent() == group3.getLoadInPercent()) word = 3;

                               //jeżeli obie są przeładowane ale 3 jst bardziej
                           else if (group2.isOverloaded() && group3.isOverloaded() &&
                                   group2.getLoadInPercent() < group3.getLoadInPercent()) word = 3;

                               //jeżeli obie są przeładowane ale 2 jst bardziej
                           else if (group2.isOverloaded() && group3.isOverloaded() &&
                                   group2.getLoadInPercent() > group3.getLoadInPercent())  word = 2;

                               //jeżeli obie są pełne
                           else if (group2.isFull() && group3.isFull()) word = 3;

                               //jeżeli 3 jest pełna
                           else if (group3.isFull()) word = 3;

                               //jeżeli 2 jest pełna
                           else if (group2.isFull()) word = 2;

                               //jeżeli obie mają więcej niż minimum
                           else if (group2.isMoreThanMinimum() && group3.isMoreThanMinimum()) {

                               //i takie smao zapełnienie
                               if (group2.getLoadInPercent() == group3.getLoadInPercent()) {
                                   word = 3;
                               }
                               // i 2 ma większe zapłenienie
                               else if (group2.getLoadInPercent() > group3.getLoadInPercent()) {
                                   word = 2;
                               }

                               // i 3 ma większe zapełnienie
                               else if (group2.getLoadInPercent() < group3.getLoadInPercent()) {
                                   word = 3;
                               }
                           }
                           //jeżeli obie mają równe minimum
                           else if (group2.isMinimum() && group3.isMinimum()) word = 3;

                               //jeżeli tylko 3 ma minimum
                           else if (group3.isMinimum()) word = 3;

                               //jeżeli tylko 2 ma ma minimum
                           else if (group2.isMinimum()) word = 2;

                               //obie mają mniej niż minimum ale 2 ma więkze zapełnienie
                           else if (group2.getLoadInPercent() > group3.getLoadInPercent()) word = 2;

                               //obie mają mniej niż minimum ale 3 ma większe zapełnienie
                           else word = 3;

                       }

                       //jeżeli poza grupą 2 grupa 4 też ma fiszki (jeżeli 3 i 5 są puste)
                       else if (group3.isEmpty() && group5.isEmpty()) {
                           //jeżeli obie są TAK SAMO przeładowane
                           if (group2.isOverloaded() && group4.isOverloaded() &&
                                   group2.getLoadInPercent() == group4.getLoadInPercent()) word = 4;

                               //jeżeli obie są przeładowane ale 4 jst bardziej
                           else if (group2.isOverloaded() && group4.isOverloaded() &&
                                   group2.getLoadInPercent() < group4.getLoadInPercent()) word = 4;

                               //jeżeli obie są przeładowane ale 2 jst bardziej
                           else if (group2.isOverloaded() && group4.isOverloaded() &&
                                   group2.getLoadInPercent() > group4.getLoadInPercent())  word = 2;

                               //jeżeli obie są pełne
                           else if (group2.isFull() && group4.isFull()) word = 4;

                               //jeżeli 4 jest pełna
                           else if (group4.isFull()) word = 4;

                               //jeżeli 2 jest pełna
                           else if (group2.isFull()) word = 2;

                               //jeżeli obie mają więcej niż minimum
                           else if (group2.isMoreThanMinimum() && group4.isMoreThanMinimum()) {

                               //i takie smao zapełnienie
                               if (group2.getLoadInPercent() == group4.getLoadInPercent()) {
                                   word = 4;
                               }
                               // i 2 ma większe zapłenienie
                               else if (group2.getLoadInPercent() > group3.getLoadInPercent()) {
                                   word = 2;
                               }

                               // i 4 ma większe zapełnienie
                               else if (group2.getLoadInPercent() < group4.getLoadInPercent()) {
                                   word = 4;
                               }
                           }
                           //jeżeli obie mają równe minimum
                           else if (group2.isMinimum() && group4.isMinimum()) word = 4;

                               //jeżeli tylko 4 ma minimum
                           else if (group4.isMinimum()) word = 4;

                               //jeżeli tylko 2 ma ma minimum
                           else if (group2.isMinimum()) word = 2;

                               //obie mają mniej niż minimum ale 2 ma więkze zapełnienie
                           else if (group2.getLoadInPercent() > group4.getLoadInPercent()) word = 2;

                               //obie mają mniej niż minimum ale 4 ma większe zapełnienie
                           else word = 4;
                       }

                       //jeżeli poza grupą 2 grupa 5 też ma fiszki (jeżeli 3 i 4 są puste)
                       else if (group3.isEmpty() && group4.isEmpty()) {
                            //jeżeli obie są TAK SAMO przeładowane
                           if (group2.isOverloaded() && group5.isOverloaded() &&
                                   group2.getLoadInPercent() == group5.getLoadInPercent()) word = 5;

                               //jeżeli obie są przeładowane ale 5 jst bardziej
                           else if (group2.isOverloaded() && group5.isOverloaded() &&
                                   group2.getLoadInPercent() < group5.getLoadInPercent()) word = 5;

                               //jeżeli obie są przeładowane ale 2 jst bardziej
                           else if (group2.isOverloaded() && group5.isOverloaded() &&
                                   group2.getLoadInPercent() > group5.getLoadInPercent())  word = 2;

                               //jeżeli obie są pełne
                           else if (group2.isFull() && group5.isFull()) word = 5;

                               //jeżeli 5 jest pełna
                           else if (group5.isFull()) word = 5;

                               //jeżeli 2 jest pełna
                           else if (group2.isFull()) word = 2;

                               //jeżeli obie mają więcej niż minimum
                           else if (group2.isMoreThanMinimum() && group5.isMoreThanMinimum()) {

                               //i takie smao zapełnienie
                               if (group2.getLoadInPercent() == group5.getLoadInPercent()) {
                                   word = 5;
                               }
                               // i 2 ma większe zapłenienie
                               else if (group2.getLoadInPercent() > group5.getLoadInPercent()) {
                                   word = 2;
                               }

                               // i 5 ma większe zapełnienie
                               else if (group2.getLoadInPercent() < group5.getLoadInPercent()) {
                                   word = 5;
                               }
                           }
                           //jeżeli obie mają równe minimum
                           else if (group2.isMinimum() && group5.isMinimum()) word = 5;

                               //jeżeli tylko 5 ma minimum
                           else if (group5.isMinimum()) word = 5;

                               //jeżeli tylko 2 ma ma minimum
                           else if (group2.isMinimum()) word = 2;

                               //obie mają mniej niż minimum ale 2 ma więkze zapełnienie
                           else if (group2.getLoadInPercent() > group5.getLoadInPercent()) word = 2;

                               //obie mają mniej niż minimum ale 5 ma większe zapełnienie
                           else word = 5;
                       }

                       //jeżeli grupy 2,3,4 mają fiszki (5 jest pusta)
                       else if (group5.isEmpty()) {

                           boolean group4and3and2areOveloaded = group4.isOverloaded() && group3.isOverloaded() && group2.isOverloaded();
                           boolean gropu4and3sameLoad = group4.getLoadInPercent() == group3.getLoadInPercent();
                           boolean gropu3and2sameLoad = group3.getLoadInPercent() == group2.getLoadInPercent();
                           boolean group4hasHighestLoadInPercent = (group4.getLoadInPercent() > group3.getLoadInPercent()) && (group4.getLoadInPercent() > group2.getLoadInPercent());
                           boolean group3hasHighestLoadInPercent = (group3.getLoadInPercent() > group4.getLoadInPercent()) && (group3.getLoadInPercent() > group2.getLoadInPercent());
                           boolean group2hasHighestLoadInPercent = (group2.getLoadInPercent() > group4.getLoadInPercent()) && (group2.getLoadInPercent() > group3.getLoadInPercent());

                           //jeżeli wszystkie są TAK SAMO przeładowane
                           if (group4and3and2areOveloaded && (gropu4and3sameLoad && gropu3and2sameLoad)) word = 4;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group4and3and2areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group4and3and2areOveloaded && group3hasHighestLoadInPercent) word = 3;
                               //jeżeli wszystkie są przeładowane ale 2 najbardziej
                           else if (group4and3and2areOveloaded && group2hasHighestLoadInPercent) word = 2;


                               //jeżeli 4 i 3 są TAK SAMO przeładowane
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 4 bardziej
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 3 bardziej
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;


                               //jeżeli 4 i 2 są TAK SAMO przeładowane
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 4 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 2 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli 3 i 2 są TAK SAMO przeładowane
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() == group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 3 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() > group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 2 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli przeładowana jest tylko 4
                           else if (group4.isOverloaded()) word = 4;
                               //jeżeli przeładowana jest tylko 3
                           else if (group3.isOverloaded()) word = 3;
                               //jeżeli przeładowana jest tylko 2
                           else if (group2.isOverloaded()) word = 2;


                               //jeżęli wszystkie 3 są pełne
                           else if (group4.isFull() && group3.isFull() && group2.isFull()) word = 4;
                               //jeżeli pełne są tylko 4 i 3
                           else if (group4.isFull() && group3.isFull()) word = 4;
                               //jeżeli pełne są tylko 4 i 2
                           else if (group4.isFull() && group2.isFull()) word = 4;
                               //jeżeli pełne są tylko 3 i 2
                           else if (group3.isFull() && group2.isFull()) word = 3;
                               //jeżeli pełna jest tylko 4
                           else if (group4.isFull()) word = 4;
                               //jeżeli pełna jest tylko 3
                           else if (group3.isFull()) word = 3;
                               //jeżeli pełna jest tylko 2
                           else if (group2.isFull()) word = 2;


                               //jeżeli wszystkie 3 mają wiecej niż minimum
                           else if (group4.isMoreThanMinimum() && group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (gropu4and3sameLoad && gropu3and2sameLoad) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 4 i 3 mają więcej niż minimum
                           else if (group4.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                           }


                           //jeżeli 4 i 2 mają więcej niż minimum
                           else if (group4.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                                   // i 2 ma największe zapełnienie
                               else if (group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli 3 i 2 mają więcej niż minimum
                           else if (group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group3.getLoadInPercent() == group2.getLoadInPercent()) word = 3;
                                   // i 3 ma największe zapełnienie
                               else if (group3.getLoadInPercent() > group2.getLoadInPercent()) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group3.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli tylko 4 ma więcej niż minimum
                           else if (group4.isMoreThanMinimum()) word = 4;
                               //jeżeli tylko 3 ma więcej niż minimum
                           else if (group3.isMoreThanMinimum()) word = 3;
                               //jeżeli tylko 2 ma więcej niż minimum
                           else if (group2.isMoreThanMinimum()) word = 2;


                               //jeżeli wszystkie 3 mają równe minimum
                           else if (group4.isMinimum() && group3.isMinimum() && group2.isMinimum()) word = 4;
                               //jeżeli tylko 4 i 3 mają równe minimum
                           else if (group4.isMinimum() && group3.isMinimum()) word = 4;
                               //jeżeli tylko 4 i 2 mają równe minimum
                           else if (group4.isMinimum() && group2.isMinimum()) word = 4;
                               //jeżeli tylko 3 i 2 mają równe minimum
                           else if (group3.isMinimum() && group2.isMinimum()) word = 3;


                               //jeżeli 4 ma minimum
                           else if (group4.isMinimum()) word = 4;
                               //jeżeli 3 ma minimum
                           else if (group3.isMinimum()) word = 3;
                               //jeżeli 2 ma minimum
                           else if (group2.isMinimum()) word = 2;


                               //jeżeli wszystkie mają mniej niż minimum
                               // ale 4 ma największe zapełneinie
                           else if (group4hasHighestLoadInPercent) word = 4;
                               // ale 3 ma największe zapełneinie
                           else if (group3hasHighestLoadInPercent) word = 3;
                               // ale 2 ma największe zapełneinie
                           else if (group2hasHighestLoadInPercent) word = 2;
                       }

                       //jeżeli grupy 2,3,5 mają fiszki (4 jest pusta)
                       else if (group4.isEmpty()) {
                           boolean group5and3and2areOveloaded = group5.isOverloaded() && group3.isOverloaded() && group2.isOverloaded();
                           boolean gropu5and3sameLoad = group5.getLoadInPercent() == group3.getLoadInPercent();
                           boolean gropu3and2sameLoad = group3.getLoadInPercent() == group2.getLoadInPercent();
                           boolean group5hasHighestLoadInPercent = (group5.getLoadInPercent() > group3.getLoadInPercent()) && (group5.getLoadInPercent() > group2.getLoadInPercent());
                           boolean group3hasHighestLoadInPercent = (group3.getLoadInPercent() > group5.getLoadInPercent()) && (group3.getLoadInPercent() > group2.getLoadInPercent());
                           boolean group2hasHighestLoadInPercent = (group2.getLoadInPercent() > group5.getLoadInPercent()) && (group2.getLoadInPercent() > group3.getLoadInPercent());

                           //jeżeli wszystkie są TAK SAMO przeładowane
                           if (group5and3and2areOveloaded && (gropu5and3sameLoad && gropu3and2sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group5and3and2areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group5and3and2areOveloaded && group3hasHighestLoadInPercent) word = 3;
                               //jeżeli wszystkie są przeładowane ale 2 najbardziej
                           else if (group5and3and2areOveloaded && group2hasHighestLoadInPercent) word = 2;


                               //jeżeli 5 i 3 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 3 bardziej
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;


                               //jeżeli 5 i 2 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 2 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli 3 i 2 są TAK SAMO przeładowane
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() == group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 3 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() > group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 2 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli przeładowana jest tylko 5
                           else if (group5.isOverloaded()) word = 5;
                               //jeżeli przeładowana jest tylko 3
                           else if (group3.isOverloaded()) word = 3;
                               //jeżeli przeładowana jest tylko 2
                           else if (group2.isOverloaded()) word = 2;


                               //jeżęli wszystkie 3 są pełne
                           else if (group5.isFull() && group3.isFull() && group2.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 3
                           else if (group5.isFull() && group3.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 2
                           else if (group5.isFull() && group2.isFull()) word = 5;
                               //jeżeli pełne są tylko 3 i 2
                           else if (group3.isFull() && group2.isFull()) word = 3;
                               //jeżeli pełna jest tylko 5
                           else if (group5.isFull()) word = 5;
                               //jeżeli pełna jest tylko 3
                           else if (group3.isFull()) word = 3;
                               //jeżeli pełna jest tylko 2
                           else if (group2.isFull()) word = 2;


                               //jeżeli wszystkie 3 mają wiecej niż minimum
                           else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (gropu5and3sameLoad && gropu3and2sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 5 i 3 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;
                                   // i 3 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                           }


                           //jeżeli 5 i 2 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                                   // i 2 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli 3 i 2 mają więcej niż minimum
                           else if (group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group3.getLoadInPercent() == group2.getLoadInPercent()) word = 3;
                                   // i 3 ma największe zapełnienie
                               else if (group3.getLoadInPercent() > group2.getLoadInPercent()) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group3.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli tylko 5 ma więcej niż minimum
                           else if (group5.isMoreThanMinimum()) word = 5;
                               //jeżeli tylko 3 ma więcej niż minimum
                           else if (group3.isMoreThanMinimum()) word = 3;
                               //jeżeli tylko 2 ma więcej niż minimum
                           else if (group2.isMoreThanMinimum()) word = 2;


                               //jeżeli wszystkie 3 mają równe minimum
                           else if (group5.isMinimum() && group3.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 3 mają równe minimum
                           else if (group5.isMinimum() && group3.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 2 mają równe minimum
                           else if (group5.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 3 i 2 mają równe minimum
                           else if (group3.isMinimum() && group2.isMinimum()) word = 3;


                               //jeżeli 5 ma minimum
                           else if (group5.isMinimum()) word = 5;
                               //jeżeli 3 ma minimum
                           else if (group3.isMinimum()) word = 3;
                               //jeżeli 2 ma minimum
                           else if (group2.isMinimum()) word = 2;


                               //jeżeli wszystkie mają mniej niż minimum
                               // ale 5 ma największe zapełneinie
                           else if (group5hasHighestLoadInPercent) word = 5;
                               // ale 3 ma największe zapełneinie
                           else if (group3hasHighestLoadInPercent) word = 3;
                               // ale 2 ma największe zapełneinie
                           else if (group2hasHighestLoadInPercent) word = 2;
                       }

                       //jeżeli grupy 2,4,5 mają fiszki (3 jest pusta)
                       else if (group3.isEmpty()) {
                           boolean group5and4and2areOveloaded = group5.isOverloaded() && group4.isOverloaded() && group2.isOverloaded();
                           boolean gropu5and4sameLoad = group5.getLoadInPercent() == group4.getLoadInPercent();
                           boolean gropu4and2sameLoad = group4.getLoadInPercent() == group2.getLoadInPercent();
                           boolean group5hasHighestLoadInPercent = (group5.getLoadInPercent() > group4.getLoadInPercent()) && (group5.getLoadInPercent() > group5.getLoadInPercent());
                           boolean group4hasHighestLoadInPercent = (group4.getLoadInPercent() > group5.getLoadInPercent()) && (group4.getLoadInPercent() > group2.getLoadInPercent());
                           boolean group2hasHighestLoadInPercent = (group2.getLoadInPercent() > group5.getLoadInPercent()) && (group2.getLoadInPercent() > group4.getLoadInPercent());

                           //jeżeli wszystkie są TAK SAMO przeładowane
                           if (group5and4and2areOveloaded && (gropu5and4sameLoad && gropu4and2sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group5and4and2areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group5and4and2areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 2 najbardziej
                           else if (group5and4and2areOveloaded && group2hasHighestLoadInPercent) word = 2;


                               //jeżeli 5 i 4 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 4 bardziej
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;


                               //jeżeli 5 i 2 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 2 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli 4 i 2 są TAK SAMO przeładowane
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 4 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 2 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;


                               //jeżeli przeładowana jest tylko 5
                           else if (group5.isOverloaded()) word = 5;
                               //jeżeli przeładowana jest tylko 4
                           else if (group4.isOverloaded()) word = 4;
                               //jeżeli przeładowana jest tylko 2
                           else if (group2.isOverloaded()) word = 2;


                               //jeżęli wszystkie 3 są pełne
                           else if (group5.isFull() && group4.isFull() && group2.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 4
                           else if (group5.isFull() && group4.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 2
                           else if (group5.isFull() && group2.isFull()) word = 5;
                               //jeżeli pełne są tylko 4 i 2
                           else if (group4.isFull() && group2.isFull()) word = 4;
                               //jeżeli pełna jest tylko 5
                           else if (group5.isFull()) word = 5;
                               //jeżeli pełna jest tylko 4
                           else if (group4.isFull()) word = 4;
                               //jeżeli pełna jest tylko 2
                           else if (group2.isFull()) word = 2;


                               //jeżeli wszystkie 3 mają wiecej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (gropu5and4sameLoad && gropu4and2sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 5 i 4 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;
                           }


                           //jeżeli 5 i 2 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                                   // i 2 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli 4 i 2 mają więcej niż minimum
                           else if (group4.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                                   // i 2 ma największe zapełnienie
                               else if (group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }


                           //jeżeli tylko 5 ma więcej niż minimum
                           else if (group5.isMoreThanMinimum()) word = 5;
                               //jeżeli tylko 4 ma więcej niż minimum
                           else if (group4.isMoreThanMinimum()) word = 4;
                               //jeżeli tylko 2 ma więcej niż minimum
                           else if (group2.isMoreThanMinimum()) word = 2;


                               //jeżeli wszystkie 3 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 4 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 2 mają równe minimum
                           else if (group5.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 4 i 2 mają równe minimum
                           else if (group4.isMinimum() && group2.isMinimum()) word = 4;


                               //jeżeli 5 ma minimum
                           else if (group5.isMinimum()) word = 5;
                               //jeżeli 4 ma minimum
                           else if (group4.isMinimum()) word = 4;
                               //jeżeli 2 ma minimum
                           else if (group2.isMinimum()) word = 2;


                               //jeżeli wszystkie mają mniej niż minimum
                               // ale 5 ma największe zapełneinie
                           else if (group5hasHighestLoadInPercent) word = 5;
                               // ale 4 ma największe zapełneinie
                           else if (group4hasHighestLoadInPercent) word = 4;
                               // ale 2 ma największe zapełneinie
                           else if (group2hasHighestLoadInPercent) word = 2;
                       }

                       //jeżeli grupy 2,3,4,5 mają fiszki
                       else {
                           boolean group5432areOverloaded = group5.isOverloaded() && group4.isOverloaded() && group3.isOverloaded() && group2.isOverloaded();
                           boolean group543areOveloaded = group5.isOverloaded() && group4.isOverloaded() && group3.isOverloaded();
                           boolean group432areOveloaded = group4.isOverloaded() && group3.isOverloaded() && group2.isOverloaded();
                           boolean group542areOveloaded = group5.isOverloaded() && group4.isOverloaded() && group2.isOverloaded();
                           boolean group532areOveloaded = group5.isOverloaded() && group3.isOverloaded() && group2.isOverloaded();

                           boolean gropu54sameLoad = group5.getLoadInPercent() == group4.getLoadInPercent();
                           boolean gropu53sameLoad = group5.getLoadInPercent() == group3.getLoadInPercent();
                           boolean gropu43sameLoad = group4.getLoadInPercent() == group3.getLoadInPercent();
                           boolean gropu42sameLoad = group4.getLoadInPercent() == group2.getLoadInPercent();
                           boolean gropu32sameLoad = group3.getLoadInPercent() == group2.getLoadInPercent();

                           boolean group5432sameLoad = gropu54sameLoad == gropu32sameLoad;
                           boolean group543sameLoad = gropu54sameLoad == gropu43sameLoad;
                           boolean group432sameLoad = gropu43sameLoad == gropu32sameLoad;
                           boolean group542sameLoad = gropu54sameLoad == gropu42sameLoad;
                           boolean group532sameLoad = gropu53sameLoad == gropu32sameLoad;

                           boolean group5hasHighestLoadInPercent = (group5.getLoadInPercent() > group4.getLoadInPercent()) && (group5.getLoadInPercent() > group3.getLoadInPercent() && (group5.getLoadInPercent() > group2.getLoadInPercent()));
                           boolean group4hasHighestLoadInPercent = (group4.getLoadInPercent() > group5.getLoadInPercent()) && (group4.getLoadInPercent() > group3.getLoadInPercent() && (group4.getLoadInPercent() > group2.getLoadInPercent()));
                           boolean group3hasHighestLoadInPercent = (group3.getLoadInPercent() > group5.getLoadInPercent()) && (group3.getLoadInPercent() > group4.getLoadInPercent() && (group3.getLoadInPercent() > group2.getLoadInPercent()));
                           boolean group2hasHighestLoadInPercent = (group2.getLoadInPercent() > group5.getLoadInPercent()) && (group2.getLoadInPercent() > group4.getLoadInPercent() && (group2.getLoadInPercent() > group3.getLoadInPercent()));


                           //jeżeli wszystkie są TAK SAMO przeładowane
                           if (group5432areOverloaded && (group5432sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group5432areOverloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group5432areOverloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group5432areOverloaded && group3hasHighestLoadInPercent) word = 3;
                                //jeżeli wszystkie są przeładowane ale 2 najbardziej
                           else if (group5432areOverloaded && group2hasHighestLoadInPercent) word = 2;


                           //jeżeli 543 są TAK samo przeładowane
                           if (group543areOveloaded && (group543sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group543areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group543areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group543areOveloaded && group3hasHighestLoadInPercent) word = 3;


                            //jeżeli 432 są tak samo przeładowane
                           if (group432areOveloaded && (group432sameLoad)) word = 4;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group432areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group432areOveloaded && group3hasHighestLoadInPercent) word = 3;
                               //jeżeli wszystkie są przeładowane ale 2 najbardziej
                           else if (group432areOveloaded && group2hasHighestLoadInPercent) word = 2;


                           //jeżeli 542 są tak samo przeładowane
                           if (group542areOveloaded && (group542sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group542areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group542areOveloaded && group4hasHighestLoadInPercent) word = 4;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group542areOveloaded && group2hasHighestLoadInPercent) word = 2;


                           //jeżeli 532 są tak samo przeładowane
                           if (group532areOveloaded && (group532sameLoad)) word = 5;
                               //jeżeli wszystkie są przeładowane ale 5 najbardziej
                           else if (group532areOveloaded && group5hasHighestLoadInPercent) word = 5;
                               //jeżeli wszystkie są przeładowane ale 4 najbardziej
                           else if (group532areOveloaded && group3hasHighestLoadInPercent) word = 3;
                               //jeżeli wszystkie są przeładowane ale 3 najbardziej
                           else if (group532areOveloaded && group2hasHighestLoadInPercent) word = 2;


                               //jeżeli 5 i 4 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 4 są przeładowane ale 4 bardziej
                           else if (group5.isOverloaded() && group4.isOverloaded() && group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;


                               //jeżeli 5 i 3 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 3 są przeładowane ale 3 bardziej
                           else if (group5.isOverloaded() && group3.isOverloaded() && group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;


                               //jeżeli 5 i 2 są TAK SAMO przeładowane
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 5 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                               // jeżeli 5 i 2 są przeładowane ale 2 bardziej
                           else if (group5.isOverloaded() && group2.isOverloaded() && group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;

                               //jeżeli 4 i 3 są TAK SAMO przeładowane
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 4 bardziej
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 3 są przeładowane ale 3 bardziej
                           else if (group4.isOverloaded() && group3.isOverloaded() && group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;

                               //jeżeli 4 i 2 są TAK SAMO przeładowane
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 4 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                               // jeżeli 4 i 2 są przeładowane ale 2 bardziej
                           else if (group4.isOverloaded() && group2.isOverloaded() && group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;

                               //jeżeli 3 i 2 są TAK SAMO przeładowane
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() == group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 3 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() > group2.getLoadInPercent()) word = 3;
                               // jeżeli 3 i 2 są przeładowane ale 2 bardziej
                           else if (group3.isOverloaded() && group2.isOverloaded() && group3.getLoadInPercent() < group2.getLoadInPercent()) word = 2;

                               //jeżeli przeładowana jest tylko 5
                           else if (group5.isOverloaded()) word = 5;
                               //jeżeli przeładowana jest tylko 4
                           else if (group4.isOverloaded()) word = 4;
                               //jeżeli przeładowana jest tylko 3
                           else if (group3.isOverloaded()) word = 3;
                               //jeżeli przeładowana jest tylko 2
                           else if (group2.isOverloaded()) word = 2;








                               //jeżęli wszystkie 4 są pełne
                           else if (group5.isFull() && group4.isFull() && group3.isFull() && group2.isFull()) word = 5;

                           //jeżeli pełne są tylko 543
                           else if (group5.isFull() && group4.isFull() && group3.isFull()) word = 5;
                           //jeżeli pełne są tylko 432
                           else if (group4.isFull() && group3.isFull() && group2.isFull()) word = 4;
                           //jeżeli pełne są tylko 542
                           else if (group5.isFull() && group4.isFull() && group2.isFull()) word = 5;
                           //jeżeli pełne są tylko 532
                           else if (group5.isFull() && group3.isFull() && group2.isFull()) word = 5;

                               //jeżeli pełne są tylko 5 i 4
                           else if (group5.isFull() && group4.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 3
                           else if (group5.isFull() && group3.isFull()) word = 5;
                               //jeżeli pełne są tylko 5 i 2
                           else if (group5.isFull() && group2.isFull()) word = 5;
                               //jeżeli pełne są tylko 4 i 3
                           else if (group4.isFull() && group3.isFull()) word = 4;
                               //jeżeli pełne są tylko 4 i 2
                           else if (group4.isFull() && group2.isFull()) word = 4;
                               //jeżeli pełne są tylko 3 i 2
                           else if (group3.isFull() && group2.isFull()) word = 3;

                               //jeżeli pełna jest tylko 5
                           else if (group5.isFull()) word = 5;
                               //jeżeli pełna jest tylko 4
                           else if (group4.isFull()) word = 4;
                               //jeżeli pełna jest tylko 3
                           else if (group3.isFull()) word = 3;
                                //jeżeli pełna jest tylko 2
                           else if (group2.isFull()) word = 2;




                               //jeżeli wszystkie 4 mają wiecej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum() &&
                                   group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5432sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 543 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group543sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                           }

                           //jeżeli 432 mająwięcej niż minimum
                           else if (group4.isMoreThanMinimum() && group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group432sameLoad) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 542 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group542sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group4hasHighestLoadInPercent) word = 4;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 532 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group532sameLoad) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5hasHighestLoadInPercent) word = 5;
                                   // i 3 ma największe zapełnienie
                               else if (group3hasHighestLoadInPercent) word = 3;
                                   // i 2 ma największe zapełnienie
                               else if (group2hasHighestLoadInPercent) word = 2;
                           }

                           //jeżeli 5 i 4 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group4.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group4.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group4.getLoadInPercent()) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group4.getLoadInPercent()) word = 4;
                           }


                           //jeżeli 5 i 3 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group3.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group3.getLoadInPercent()) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                           }

                            //jeżeli 5 i 2 mają więcej niż minimum
                           else if (group5.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group5.getLoadInPercent() == group2.getLoadInPercent()) word = 5;
                                   // i 5 ma największe zapełnienie
                               else if (group5.getLoadInPercent() > group2.getLoadInPercent()) word = 5;
                                   // i 4 ma największe zapełnienie
                               else if (group5.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }

                           //jeżeli 4 i 3 mają więcej niż minimum
                           else if (group4.isMoreThanMinimum() && group3.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group4.getLoadInPercent() == group3.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4.getLoadInPercent() > group3.getLoadInPercent()) word = 4;
                                   // i 3 ma największe zapełnienie
                               else if (group4.getLoadInPercent() < group3.getLoadInPercent()) word = 3;
                           }

                           //jeżeli 4 i 2 mają więcej niż minimum
                           else if (group4.isMoreThanMinimum() && group2.isMoreThanMinimum()) {
                               //i takie samo zapełnienie
                               if (group4.getLoadInPercent() == group2.getLoadInPercent()) word = 4;
                                   // i 4 ma największe zapełnienie
                               else if (group4.getLoadInPercent() > group2.getLoadInPercent()) word = 4;
                                   // i 2 ma największe zapełnienie
                               else if (group4.getLoadInPercent() < group2.getLoadInPercent()) word = 2;
                           }

                           //jeżeli tylko 5 ma więcej niż minimum
                           else if (group5.isMoreThanMinimum()) word = 5;
                               //jeżeli tylko 4 ma więcej niż minimum
                           else if (group4.isMoreThanMinimum()) word = 4;
                               //jeżeli tylko 3 ma więcej niż minimum
                           else if (group3.isMoreThanMinimum()) word = 3;
                               //jeżeli tylko 2 ma więcej niż minimum
                           else if (group2.isMoreThanMinimum()) word = 2;


                               //jeżeli wszystkie 4 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum() && group3.isMinimum() && group2.isMinimum()) word = 5;

                                //jeżeli tylko 543 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum() && group3.isMinimum()) word = 5;
                               //jeżeli tylko 432 mająrówne minimum
                           else if (group4.isMinimum() && group3.isMinimum() && group2.isMinimum()) word = 4;
                               //jeżeli tylko 542 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 532 mają równe minimum
                           else if (group5.isMinimum() && group3.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 4 mają równe minimum
                           else if (group5.isMinimum() && group4.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 3 mają równe minimum
                           else if (group5.isMinimum() && group3.isMinimum()) word = 5;
                               //jeżeli tylko 5 i 2 mają równe minimum
                           else if (group5.isMinimum() && group2.isMinimum()) word = 5;
                               //jeżeli tylko 4 i 3 mają równe minimum
                           else if (group4.isMinimum() && group3.isMinimum()) word = 4;
                               //jeżeli tylko 4 i 2 mają równe minimum
                           else if (group4.isMinimum() && group2.isMinimum()) word = 4;

                               //jeżeli 5 ma minimum
                           else if (group5.isMinimum()) word = 5;
                               //jeżeli 4 ma minimum
                           else if (group4.isMinimum()) word = 4;
                               //jeżeli 3 ma minimum
                           else if (group3.isMinimum()) word = 3;
                                //jeżeli 2 ma minimum
                           else if (group2.isMinimum()) word = 2;

                               //jeżeli wszystkie mają mniej niż minimum
                               // ale 5 ma największe zapełneinie
                           else if (group5hasHighestLoadInPercent) word = 5;
                               // ale 4 ma największe zapełneinie
                           else if (group4hasHighestLoadInPercent) word = 4;
                               // ale 3 ma największe zapełneinie
                           else if (group3hasHighestLoadInPercent) word = 3;
                                // ale 2 ma największe zapełneinie
                           else if (group2hasHighestLoadInPercent) word = 2;

                       }




                   }





               }

               // jeżeli grupa 1 ma fiszki
               else {




               }



           }

           //jeżeli grupa 0 ma fiszki
           else {



           }









//           if (group1.isOverloaded()) word = 1;
//           else if (group2.isOverloaded()) word = 2;
//           else if (group3.isOverloaded()) word = 3;
//           else if (group4.isOverloaded()) word = 4;
//           else if (group5.isOverloaded()) word = 5;
//           else if (group5.isFull()) word = 5;
//           else if (group4.isFull()) word = 4;
//           else if (group3.isFull()) word = 3;
//           else if (group2.isFull()) word = 2;
//           else if (group1.isFull()) word = 1;
//
//
//           else if (group1.getLoadInPercent() == getMaxPercent() && group1.getLoadInPercent() > group1.getMinSize()) word = 1;
//           else if (group2.getLoadInPercent() == getMaxPercent() && group2.getLoadInPercent() > group2.getMinSize()) word = 2;
//           else if (group3.getLoadInPercent() == getMaxPercent() && group3.getLoadInPercent() > group3.getMinSize()) word = 3;
//           else if (group4.getLoadInPercent() == getMaxPercent() && group4.getLoadInPercent() > group4.getMinSize()) word = 4;
//           else if (group5.getLoadInPercent() == getMaxPercent() && group5.getLoadInPercent() > group5.getMinSize()) word = 5;
//
//
//           else if (!group0.isEmpty()) {
//               if (group1.isMinimum() &&
//                       group2.isMinimum() &&
//                       group3.isMinimum() &&
//                       group4.isMinimum() &&
//                       group5.isMinimum()) word = 0;
//
//               else if (group1.isEmpty() &&
//                       group2.isEmpty() &&
//                       group3.isEmpty() &&
//                       group4.isEmpty() &&
//                       group5.isEmpty()) word = 0;
//
//               else if (group1.isEmpty()) word = 0;
//
//           } else {
//               word = 1;
//           }






       }



        return word;
    }



    private double getMaxPercent() {
        return Math.max(group1.getLoadInPercent(),
               Math.max(group2.getLoadInPercent(),
               Math.max(group3.getLoadInPercent(),
               Math.max(group4.getLoadInPercent(), group5.getLoadInPercent()))));
    }

    public void setGroupSizes(int g0, int g1, int g2, int g3, int g4, int g5) {
        group0.addElem(g0);
        group1.addElem(g1);
        group2.addElem(g2);
        group3.addElem(g3);
        group4.addElem(g4);
        group5.addElem(g5);
    }


}
