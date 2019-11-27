package chapter_3;


import structures.LinkedList;

/**
 * Sort Stack
 *
 * Write a program to sort a stack such that the smallest items are on the top.
 * You can use an additional temporary stack, but you may not copy the elements into any other data structure
 * (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        LinkedList<Integer> origin = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            origin.push(i);
        }

        System.out.println(sort(origin));
    }

    // Complexity: O(n^2)
    private static LinkedList<Integer> sort(LinkedList<Integer> origin) {
        LinkedList<Integer> result = new LinkedList<>();

        while (!origin.isEmpty()) {
            int current = origin.pop();

            while (!result.isEmpty() && result.peek() > current) {
                origin.push(result.pop());
            }
            result.push(current);
        }

        return result;
    }
}
