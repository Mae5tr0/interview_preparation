package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

/**
 * Sum Lists
 *
 * You have two numbers represented by a linked list, where each node contains a single digit.The digits are
 * stored in reverse order, such that the 1 's digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList<>((Arrays.asList(7, 1, 6)));
        LinkedList<Integer> b = new LinkedList<>((Arrays.asList(5, 9, 2)));
        System.out.println(sum(a, b)); // 2, 1, 9
    }

    // Complexity: a + b -> O(a), memory: O(1)
    private static LinkedList<Integer> sum(LinkedList<Integer> first, LinkedList<Integer> second) {
        int maxLength = Math.max(first.length(), second.length());
        LinkedList.Node<Integer> fistNode = first.getNode(0);
        LinkedList.Node<Integer> secondNode = second.getNode(0);
        LinkedList<Integer> result = new LinkedList<>();
        boolean rest = false;

        for (int i = maxLength; i > 0; i--) {
            int sum = rest ? 1 : 0;
            rest = false;
            if (fistNode != null) {
                sum += fistNode.item;
                fistNode = fistNode.next;
            }
            if (secondNode != null) {
                sum += secondNode.item;
                secondNode = secondNode.next;
            }

            if (sum >= 10) {
                result.addLast(sum - 10);
                rest = true;
            } else {
                result.addLast(sum);
            }
        }

        return result;
    }
}
