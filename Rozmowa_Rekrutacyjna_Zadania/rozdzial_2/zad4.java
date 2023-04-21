package rozdzial_2;

public class zad4 {

     /*
     * Napisz kod, który dzieli listę powiązaną na podstawie wartości x.
     * Wszystkie węęzły mniejsze od x mają się znaleźć przed wszystkimi węzłami
     * większymi od x lub równymi tej wartości.
     */

    public static void main(String[] args) {


    }


    private static LinkedListNode partition(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        //Dzielenie listy
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;
            if (node.data < x) {
                //wstawianie węzła na koniec listy before
                if (beforeStart == null) {
                    beforeStart = node;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = node;
                    beforeEnd = node;
                }
            } else {
                //wstawianie węzła na koniec listy after
                if (afterStart == null) {
                    afterStart = node;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = node;
                    afterEnd = node;
                }
            }
            node = next;
        }
        if (beforeStart == null) return afterStart;

        //scalanie list before i after
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    private static LinkedListNode partition2(LinkedListNode node, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode afterStart = null;

        //Dzielenie listy
        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < x) {
                //wstawianie węzła na początek listy before
                node.next = beforeStart;
                beforeStart = node;
            } else {
                //wstawianie węzła na początek listy after
                node.next = afterStart;
                afterStart = node;
            }
            node = next;
        }
        if (beforeStart == null) return afterStart;

        LinkedListNode head = beforeStart;
        while (beforeStart.next != null) {
            beforeStart = beforeStart.next;
        }
        beforeStart.next = afterStart;
        return head;
    }




    private static class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }


}
