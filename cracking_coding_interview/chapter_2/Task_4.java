package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

/**
 * Partition
 *
 * Write code to partition a linked list around a value x, such that all nodes less than x come before all
 * nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after
 * the elements less than x (see below). The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>((Arrays.asList(3, 5, 8, 5, 10, 2, 1)));
        System.out.println(splitOnPartitions(list, 5)); // 3, 1, 2, 10, 5, 5, 8
    }

    // TODO
    private static <E> LinkedList<E> splitOnPartitions(LinkedList<E> list, int partition) {


        return list;
    }
}
