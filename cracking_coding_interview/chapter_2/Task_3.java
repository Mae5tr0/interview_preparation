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
        LinkedList.ListNode<E> removedListNode = list.getNode(position);
        LinkedList.ListNode<E> nextListNode = list.getNode(position + 1);

        removedListNode.item = nextListNode.item;
        removedListNode.next = nextListNode.next;

        return list;
    }
}
