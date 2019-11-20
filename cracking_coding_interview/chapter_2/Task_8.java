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
        LinkedList.Node<String> cNode = list.getNode(2);
        LinkedList.Node<String> eNode = list.getNode(4);
        eNode.next = cNode;

        System.out.println(findLoop(list)); //C
    }

    // Complexity:
    private static <E> LinkedList.Node<E> findLoop(LinkedList<E> input) {
        HashSet<LinkedList.Node<E>> set = new HashSet<>();

        LinkedList.Node<E> node = input.getNode(0);

        while (node != null) {
            if (set.contains(node)) return node;

            set.add(node);
            node = node.next;
        }

        return null;
    }
}
