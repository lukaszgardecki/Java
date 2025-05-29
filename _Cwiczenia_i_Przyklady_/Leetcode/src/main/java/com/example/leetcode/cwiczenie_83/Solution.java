package com.example.leetcode.cwiczenie_83;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Jeśli lista jest pusta lub ma tylko jeden element, nie ma duplikatów do usunięcia.
        if (head == null || head.next == null) {
            return head;
        }

        // Używamy wskaźnika 'current' do przechodzenia przez listę.
        // Zaczynamy od głowy.
        ListNode current = head;

        // Przechodzimy przez listę, dopóki 'current' i 'current.next' istnieją.
        // Musimy sprawdzić 'current.next', ponieważ porównujemy bieżący węzeł z następnym.
        while (current.next != null) {
            // Jeśli wartość bieżącego węzła jest taka sama jak wartość następnego węzła...
            if (current.val == current.next.val) {
                // ...wtedy "pomijamy" następny węzeł.
                // Oznacza to, że 'next' 'current' węzła staje się 'next' 'current.next' węzła.
                // Efektywnie usuwamy duplikat.
                current.next = current.next.next;
            } else {
                // Jeśli wartości są różne, przechodzimy do następnego węzła.
                current = current.next;
            }
        }

        // Zwracamy oryginalną głowę listy, ponieważ operacje były wykonywane "in-place".
        return head;
    }
}
