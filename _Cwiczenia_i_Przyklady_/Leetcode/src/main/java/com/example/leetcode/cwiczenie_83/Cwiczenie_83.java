package com.example.leetcode.cwiczenie_83;

class Cwiczenie_83 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));

        ListNode result = solution.deleteDuplicates(l1);
        display(result);
    }

    private static void display(ListNode listNode) {
        ListNode f = listNode;
        while (f != null) {
            System.out.println(f.val);
            f = f.next;
        }
    }
}
