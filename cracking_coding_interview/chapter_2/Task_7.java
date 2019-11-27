package chapter_2;

import structures.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Intersection
 *
 * Given two (singly) linked lists, determine if the two lists intersect.
 * Return the intersecting node. Note that the intersection is defined based on reference, not value.
 * That is, if the kth node of the first linked list is the exact same node (by reference)
 * as the jth node of the second linked list, then they are intersecting.
 *
 */
public class Task_7 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D"));
        LinkedList.ListNode<String> cListNode = list.getNode(2);

        LinkedList<String> list_2 = new LinkedList<>(Arrays.asList("X", "C", "Y", "Z"));
        LinkedList.ListNode<String> xListNode = list_2.getNode(0);
        LinkedList.ListNode<String> yListNode = list_2.getNode(2);

        xListNode.next = cListNode;
        yListNode.prev = cListNode;

        System.out.println(intersection(list, list_2)); // C
    }

    // Complexity: a + b -> O(a), Memory: O(a)
    private static <E> LinkedList.ListNode<E> intersection(LinkedList<E> aList, LinkedList<E> bList) {
        HashSet<LinkedList.ListNode<E>> set = new HashSet<>();

        LinkedList.ListNode<E> aListNode = aList.getNode(0);

        while (aListNode != null) {
            set.add(aListNode);
            aListNode = aListNode.next;
        }

        LinkedList.ListNode<E> bListNode = bList.getNode(0);
        while (bListNode != null) {
            if (set.contains(bListNode)) return bListNode;
            bListNode = bListNode.next;
        }

        return null;
    }
}
