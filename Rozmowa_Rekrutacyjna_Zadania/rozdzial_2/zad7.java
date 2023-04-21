package rozdzial_2;

import java.util.Stack;

public class zad7 {

     /*
     * Zaimplementuj funkcję, która sprawdza, czy dana lista powiązana jest palindromem.
     */

    public static void main(String[] args) {

    }


    private static boolean isPalindrome(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        Stack<Integer> stack = new Stack<>();
        //umieszczenie elementów z pierwszej połowy listy powiązanej na stosie.
        //Gdy szybki wskaźnik (przesuwany po dwa elementy) dotrze do końca listy powiązanej,
        //będzie wiadomo, że wolny dotarł do jej połowy
        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //liczba elementów jest nieparzysta, dlatego można pominąć środkową wartość
        if (fast != null) slow = slow.next;

        while (slow != null) {
            int top = stack.pop();

            //jeśli wartości są różne, lista nie jest palindromem
            if (top != slow.data) return false;

            slow = slow.next;
        }
        return true;
    }

    private static class LinkedListNode {
        private int data;
        private LinkedListNode prev;
        private LinkedListNode next;

        public LinkedListNode() {
        }

        public LinkedListNode(int data, LinkedListNode prev, LinkedListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }


}
