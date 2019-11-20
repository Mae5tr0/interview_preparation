package chapter_2;

import structures.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Remove Dups
 *
 * Write code to remove duplicates from an unsorted linked list.
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>((Arrays.asList("A", "B", "C", "A", "D", "B", "E")));
        System.out.println(removeDuplicates(list)); // A, B, C, D, E
    }

    // Complexity: n + const -> O(n), Memory: 2n -> O(n)
    private static <E> LinkedList<E> removeDuplicates(LinkedList<E> list) {
        HashSet<E> buffer = new HashSet<>();

        LinkedList<E> result = new LinkedList<>();
        // we can optimize solution by removing duplicated node directly from list
        for (E el : list) {
            if (!buffer.contains(el)) {
                buffer.add(el);
                result.addLast(el);
            }
        }

        return result;
    }
}
