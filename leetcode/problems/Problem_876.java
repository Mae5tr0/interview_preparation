package problems;

/**
 * (Middle of the Linked List)[https://leetcode.com/problems/middle-of-the-linked-list/]
 *
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 */
public class Problem_876 {
    public static void main(String[] args) {
        int[][] testCases = {
            {1, 2, 3, 4, 5}, // 3
            {1, 2, 3, 4, 5, 6}, // 4
            {1}, // 1
            {1, 2}, // 2
            {1, 2, 3} // 2
        };

        for (int[] input : testCases) {
            ListNode listHead = buildList(input);
            System.out.println(listHead);
//            System.out.println(middleNode(listHead).val);
            System.out.println(middleNode2(listHead).val);
        }
    }

    // Functional approach
    public static ListNode middleNode(ListNode head) {
        return get(head, size(head) / 2);
    }

    public static ListNode get(ListNode node, int position) {
        if (node == null) return null;
        if (position == 0) return node;

        return get(node.next, position - 1);
    }

    public static int size(ListNode node) {
        if (node == null) return 0;

        return 1 + size(node.next);
    }

    // Fast and slow pointers
    public static ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helpers
    public static ListNode buildList(int[] arr) {
        ListNode head = new ListNode(arr[0]);

        ListNode node = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            node.next = next;
            node = next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return next == null ? Integer.toString(val) :  val + " -> " + next;
        }
    }
}