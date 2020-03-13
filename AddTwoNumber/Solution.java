class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 递归版本
         */

        return add(l1, l2, 0);
    }

    private static ListNode add(ListNode l1, ListNode l2, int i) {
        if (l1 == null && l2 == null && i == 0) {
            return null;
        }

        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int z = l1.val + l2.val + i;
        ListNode root = new ListNode(z % 10);
        root.next = add(l1.next, l2.next, z / 10);

        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(5);

        ListNode result = addTwoNumbers(l1, l2);
    }
}