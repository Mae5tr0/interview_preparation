package problems;


/**
 * (Perform String Shifts)[https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3299/]
 *
 * You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * * direction can be 0 (for left shift) or 1 (for right shift).
 * * amount is the amount by which string s is to be shifted.
 * * A left shift by 1 means remove the first character of s and append it to the end.
 * * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 *
 * Return the final string after all operations.
 *
 */
public class Problem_9999_2 {
    static class Node {
        char val;
        Node prev;
        Node next;

        public Node(char c) {
            this.val = c;
        }
    }

    public static void main(String[] args) {
        int[][] shifts = new int[][]{ {1, 1}, {1, 1}, {0, 2}, {1, 3} };
        System.out.println(stringShift("abcdefg", shifts)); // efgabcd
        System.out.println(stringShift("a", shifts)); // a
        System.out.println(stringShift("", shifts)); // a
    }

    public static String stringShift(String s, int[][] shifts) {
        if (s.isEmpty()) return "";

        Node current = buildList(s);

        for (int[] shift : shifts) {
            if (shift[0] != 0) {
                for (int i = shift[1]; i > 0; i--) {
                    current = current.prev;
                }
            } else {
                for (int i = shift[1]; i > 0; i--) {
                    current = current.next;
                }
            }
        }

        return buildString(current);
    }

    public static Node buildList(String s) {
        char[] letters = s.toCharArray();
        Node first = new Node(letters[0]);
        Node prev = first;
        for (int i = 1; i < letters.length; i++) {
            prev.next = new Node(letters[i]);
            prev.next.prev = prev;
            prev = prev.next;
        }
        first.prev = prev;
        prev.next = first;

        return first;
    }

    public static String buildString(Node first) {
        StringBuilder result = new StringBuilder();

        result.append(first.val);
        Node next = first.next;
        while (next != first) {
            result.append(next.val);
            next = next.next;
        }

        return result.toString();
    }
}