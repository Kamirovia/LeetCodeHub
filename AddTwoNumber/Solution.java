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

        //ListNode result = addTwoNumbers(l1, l2);
        ListNode r2 = addTwoNumbersWithLoop(l1, l2);
    }

    /**
     * 非递归版本 使用循环代替递归, 保留l1，逐步检查l2，维护进位t
     * 
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbersWithLoop(ListNode l1, ListNode l2) {
        int t = 0;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // 处理中间段
        ListNode c1 = l1;
        ListNode c2 = l2;
        int cval1 = 0;
        int cval2 = 0;

        while (!(c1 == null && c2 == null && t == 0)) {
            if (c1 == null) {
                cval1 = 0;
            } else
                cval1 = c1.val;

            if (c2 == null) {
                cval2 = 0;
            } else
                cval2 = c2.val;

            // 判断进位
            int z = cval1 + cval2 + t;
            // 更新进位信息
            t = z / 10;

            // 保存一位余数在对应的节点,分情况讨论：
            // L1短，L2长，C1下一个节点为空，判断C2的后面节点是否存在
            // 1)存在，L1保留，续用C2后面的节点
            // 2)不存在，判断进位标志是否为1
            //   2.1) 进位为0，不需要处理；
            //   2.2) 进位为1，最后new一个节点，赋值为1.
            if (c1 != null && c1.next == null && c2 != null && c2.next != null) {
                c1.val = z % 10;
                c1.next = c2.next;

                c1 = c1.next;
                c2 = null;
            } else if (c1 != null && c1.next == null && c2 == null && t == 1) {
                c1.val = z % 10;
                c1.next = new ListNode(1);

                t = 0;
                break;
            } else {
                c1.val = z % 10;
                c1 = c1.next;
                c2 = c2.next;
            }

        }


        return l1;
    }
}