package chapter_2;

import structures.LinkedList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Loop Detection:
 *
 * Given a circular linked list, implement an algorithm that returns the node at the
 * beginning of the loop.
 *
 */
public class Task_8 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        LinkedList.ListNode<String> cListNode = list.getNode(2);
        LinkedList.ListNode<String> eListNode = list.getNode(4);
        eListNode.next = cListNode;

        System.out.println(findLoop(list)); //C
    }

    // Complexity:
    private static <E> LinkedList.ListNode<E> findLoop(LinkedList<E> input) {
        HashSet<LinkedList.ListNode<E>> set = new HashSet<>();

        LinkedList.ListNode<E> listNode = input.getNode(0);

        while (listNode != null) {
            if (set.contains(listNode)) return listNode;

            set.add(listNode);
            listNode = listNode.next;
        }

        return null;
    }
}
