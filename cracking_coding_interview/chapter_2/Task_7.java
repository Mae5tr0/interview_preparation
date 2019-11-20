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
        LinkedList.Node<String> cNode = list.getNode(2);

        LinkedList<String> list_2 = new LinkedList<>(Arrays.asList("X", "C", "Y", "Z"));
        LinkedList.Node<String> xNode = list_2.getNode(0);
        LinkedList.Node<String> yNode = list_2.getNode(2);

        xNode.next = cNode;
        yNode.prev = cNode;

        System.out.println(intersection(list, list_2)); // C
    }

    // Complexity: a + b -> O(a), Memory: O(a)
    private static <E> LinkedList.Node<E> intersection(LinkedList<E> aList, LinkedList<E> bList) {
        HashSet<LinkedList.Node<E>> set = new HashSet<>();

        LinkedList.Node<E> aNode = aList.getNode(0);

        while (aNode != null) {
            set.add(aNode);
            aNode = aNode.next;
        }

        LinkedList.Node<E> bNode = bList.getNode(0);
        while (bNode != null) {
            if (set.contains(bNode)) return bNode;
            bNode = bNode.next;
        }

        return null;
    }
}
