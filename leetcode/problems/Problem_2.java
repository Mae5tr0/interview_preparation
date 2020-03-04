package problems;

/**
 * (Add Two Numbers)[https://leetcode.com/problems/add-two-numbers/]
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 */
public class Problem_2 {
    public static void main(String[] args) {
        ListNode x1 = new ListNode(2);
        ListNode x2 = new ListNode(4);
        ListNode x3 = new ListNode(3);
        x1.next = x2;
        x2.next = x3;

        ListNode y1 = new ListNode(5);
        ListNode y2 = new ListNode(6);
        ListNode y3 = new ListNode(4);
        ListNode y4 = new ListNode(1);
        ListNode y5 = new ListNode(2);
        y1.next = y2;
        y2.next = y3;
        y3.next = y4;
        y4.next = y5;

        System.out.println(x1);
        System.out.println(y1);
        System.out.println(addTwoNumbers(x1, y1));
    }

    static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        boolean rest = false;
        ListNode l1Next = l1;
        ListNode l2Next = l2;
        ListNode current = null;

        while (l1Next != null || l2Next != null) {
            int sum = rest ? 1 : 0;
            rest = false;
            if (l1Next != null) {
                sum += l1Next.val;
                l1Next = l1Next.next;
            }
            if (l2Next != null) {
                sum += l2Next.val;
                l2Next = l2Next.next;
            }

            if (sum >= 10) {
                sum -= 10;
                rest = true;
            }
            ListNode node = new ListNode(sum);
            if (current != null) {
                current.next = node;
            } else {
                result = node;
            }
            current = node;
        }
        if (rest) {
            current.next = new ListNode(1);
        }

        return result;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }

        @Override
        public String toString() {
            return "" + val + (next == null ? "" : " -> " + next.toString());
        }
    }
}
