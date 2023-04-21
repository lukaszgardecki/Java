package rozdzial_2;

import java.util.HashSet;

public class zad1 {

     /*
     * Napisz kod, który usuwa duplikaty z nieposortowanej listy powiązanej.
     * Jak rozwiążesz ten problem, jeśli niedozwolone jest stosowanie tymczasowego bufora?
     */

    public static void main(String[] args) {


    }

    private static void deleteDups(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    private static void deleteDups2(LinkedListNode head) {
        if (head == null) return;

        LinkedListNode current = head;
        while (current != null) {
            LinkedListNode runner = current;
            while (runner.next != current) {
                if (runner.next.data == current.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    private static class LinkedListNode {
        private int data;
        private LinkedListNode next;
    }


}
