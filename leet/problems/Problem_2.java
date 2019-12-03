package problems;

/**
 * Add Two Numbers
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
        Solution solution = new Solution();
        ListNode x1 = new ListNode(2);
        ListNode x2 = new ListNode(3);
        ListNode x3 = new ListNode(4);
        x1.next = x2;
        x2.next = x3;

        ListNode y1 = new ListNode(5);
        ListNode y2 = new ListNode(6);
        ListNode y3 = new ListNode(4);
        y1.next = y2;
        y2.next = y3;

        System.out.println(solution.addTwoNumbers(x1, y1));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            boolean rest = false;
            ListNode l1Next = l1;
            ListNode l2Next = l2;
            ListNode prev = null;
            ListNode current;
            ListNode start = null;

            while (l1Next == null && l2Next == null) {
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
                current = new ListNode(sum);
                if (prev == null) {
                    prev = current;
                    start = current;
                } else {
                    prev.next = current;
                    prev = current;
                }
            }
            if (rest) {
                prev.next = new ListNode(1);
            }

            return start;
        }
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
