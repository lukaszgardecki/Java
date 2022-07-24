class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        // implement the method
        int counter1 = 0;
        int counter2 = 0;

        for (Integer l1 : list1) {
            if (l1 == elem) counter1++;
        }
        for (Integer l2 : list2) {
            if (l2 == elem) counter2++;
        }
        return counter1 == counter2;
    }
}