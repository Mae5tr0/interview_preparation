package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

/**
 * Delete Middle Node
 *
 * Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node,
 * not necessarily the exact middle) of a singly linked list, given only access to that node.
 *
 */
public class Task_3 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>((Arrays.asList("A", "B", "C", "D", "E", "F")));
        System.out.println(deleteNode(list, 2)); // A, B, D, E, F
    }

    // Complexity: O(position)
    private static <E> LinkedList<E> deleteNode(LinkedList<E> list, int position) {
        LinkedList.Node<E> removedNode = list.getNode(position);
        LinkedList.Node<E> nextNode = list.getNode(position + 1);

        removedNode.item = nextNode.item;
        removedNode.next = nextNode.next;

        return list;
    }
}
