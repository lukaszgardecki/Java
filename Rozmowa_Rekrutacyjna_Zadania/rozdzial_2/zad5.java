package rozdzial_2;

public class zad5 {

     /*
     * Dostępne są dwie liczby zapisane na liście powiązanej, w której każdy węzeł zawiera jedną
     * cyfrę. Cyfry są zapisane w odwrotnej kolejności (cyhfra jedności jest głową listy). Napisz funkcję,
     * która dodaje te dwie liczby i zwraca sumę zapisaną na liście powiązanej.
     *
     * Wykonaj to samo zadanie przy założeniu, że cyfry są zapisane w standardowej kolejności
     * (cyfra jedności jest ogonem listy).
     */

    public static void main(String[] args) {


    }


    private static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {

        //Proces jest zakończony, gyd obli listy są puste ORAZ przenoszona wartość to 0
        if (l1 == null && l2 == null && carry == 0) return null;

        LinkedListNode result = new LinkedListNode();

        //Dodawanie zmiennej value i danych z list l1 i l2
        int value = carry;
        if (l1 != null) value += l1.data;
        if (l2 != null) value += l2.data;

        result.data = value % 10; // druga cyfra liczby

        //Rekurencja
        if (l1 != null || l2 != null) {
            LinkedListNode more = addLists(l1 == null ? null : l1.next,
                                           l2 == null ? null : l2.next,
                                           value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    LinkedListNode addLists2(LinkedListNode l1, LinkedListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        // uzupełenienie krótszej listy zerami
        if (len1 < len2) {
            l1 = padList(l1, len2 - len1);
        } else {
            l2 = padList(l2, len1 - len2);
        }

        //dodawanie list
        PartialSum sum = addListsHelper(l1, l2);

        //Jeśli trzeba przenieść wartość, należy wstawić ją na poczatek listy.
        //W przeciwnym razie wystarczy zwrócić daną listę
        if (sum.carry == 0) {
            return sum.sum;
        } else {
            LinkedListNode result = insertBefore(sum.sum, sum.carry);
            return  result;
        }
    }

    private PartialSum addListsHelper(LinkedListNode l1, LinkedListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        // rekurecynyjne dodawanie dalszych cyfr
        PartialSum sum = addListsHelper(l1.next, l2.next);

        //Dodawanie przeniesienia do bieżących wartości
        int val = sum.carry + l1.data + l2.data;

        //Wstawianie sumy cyfr
        LinkedListNode fullResult = insertBefore(sum.sum, val % 10);

        // Zwracanie obliczone jsumy i przenoszonej wartości
        sum.sum = fullResult;
        sum.carry = val / 10;
        return sum;
    }

    // metoda pomocnicza wstawaiająca węzeł na początek listy powiazanej
    private LinkedListNode insertBefore(LinkedListNode list, int data) {
        LinkedListNode node = new LinkedListNode(data, null, null);
        if (list != null) {
            list.prev = node;
            node.next = list;
        }
        return node;
    }

    // metoda uzupełniająca listę zerami
    private LinkedListNode padList(LinkedListNode l, int padding) {
        LinkedListNode head = l;
        for (int i = 0; i < padding; i++) {
            LinkedListNode n = new LinkedListNode(0, null, null);
            head.prev = n;
            n.next = head;
            head = n;
        }
        return head;
    }

    // metoda zwracająca długośc listy powiązanej
    private int length(LinkedListNode node) {
        int counter = 0;
        LinkedListNode next = node.next;
        while (next != null) {
            counter++;
            next = next.next;
        }
        return counter;
    }

    private static class PartialSum {
        private LinkedListNode sum = null;
        private int carry = 0;
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
