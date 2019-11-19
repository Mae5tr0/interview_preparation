package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

/**
 * Return Kth to Last
 *
 * Implement an algorithm to find the kth to last element of a singly linked list.
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>((Arrays.asList("A", "B", "C", "A", "D", "B", "E")));
        System.out.println(findK(list, 5)); //C
    }

    // Complexity: O(n), Memory: k -> O(k)
    private static <E> E findK(LinkedList<E> input, int k) {
        // Using limited queue will be more clearly
        LinkedList<E> queue = new LinkedList<>();
        for (E el : input) {
            queue.addLast(el);
            if (queue.size() > k) {
                queue.removeFirst();
            }
        }

        return queue.getFirst();
    }
}
