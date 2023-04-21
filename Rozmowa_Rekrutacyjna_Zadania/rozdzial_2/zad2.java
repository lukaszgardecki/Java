package rozdzial_2;

public class zad2 {

     /*
     * Zaimplementuj algorytm wyszukujący na liście jedokrotnie powiązanej k-ty element od końca.
     */

    public static void main(String[] args) {


    }

    // 1. WERSJA REKURENCYJNA. PODEJŚCIE A. BEZ ZWRACANIA ELEMENTU. Algorytm wymaga O(n) pamięci
    private static int nthToLast(LinkedListNode head, int k) {
        if (head == null) return 0;

        int i = nthToLast(head.next, k) + 1;
        if (i == k) {
            System.out.println(head.data);
        }
        return i;
    }

    // 2. WERSJA ITERACYJNA. Ten algorytn działa w czasie O(n) i wymaga O(1) pamięci.
    private static LinkedListNode nthToLast2(LinkedListNode head, int k) {
        if (k <= 0) return null;

        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        //Przesuwanie p2 o k węzłów dalej na liście
        for (int i = 0; i < k - 1; i++) {
            if (p2 == null) return null; //wykrywanie błędów
            p2 = p2.next;
        }
        if (p2 == null) return  null;

        // Należy przesuwać p1 i p2 z taką samą szybkością. Gdy p2 dotrze do końca, p1 będzie wskazywać odopowiedni element
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }



    private static class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }


}
