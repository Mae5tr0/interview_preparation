package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

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

    private static String findLoop(LinkedList<String> input) {

        return "";
    }
}
