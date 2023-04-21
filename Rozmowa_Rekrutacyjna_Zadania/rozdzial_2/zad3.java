package rozdzial_2;

public class zad3 {

     /*
     * Zaimplementuj algorytm, który usuwa węzeł ze środka listy jednokrotnie powiązanej, mając dostęp tylko do tego węzła.
     */

    public static void main(String[] args) {


    }


    private static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) return false;
        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }




    private static class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }


}
