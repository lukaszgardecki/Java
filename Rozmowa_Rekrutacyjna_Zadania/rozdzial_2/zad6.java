package rozdzial_2;

public class zad6 {

     /*
     * Zaimplementuj algorytm, który przyjmuje listę powiązaną z pętlą i zwraca węzeł będący początkiem pętli.
     */

    public static void main(String[] args) {

    }


    private static LinkedListNode findBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        //znajdowanie punktu spotkania. Jest on oddalony o LOOP_SIZE - k kroków od poczatku listy powiązanej
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break; //spotkanie
        }

        //wykrywanie błędów - wskaźniki się nie spotkały, więc pętla nie istnieje
        if (fast == null || fast.next == null) return null;

        //przesuwanie wolnego wskaźnik na początek. Szybki pozostaje w punkcie spotkania.
        //oba znajdują się wtedy k kroków od początku pętli. Jeśli będą przesuwane w tym
        //samym tempie, spoktają się na poczatku pętli
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //teraz oba wskaźniki wskazują początek pętli
        return  fast;
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
