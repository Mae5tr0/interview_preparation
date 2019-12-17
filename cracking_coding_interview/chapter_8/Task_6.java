package chapter_8;

import structures.LinkedList;

/**
 * Towers of Hanoi
 *
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes which can slide
 * onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (i.e., each disk sits on top of an even larger one).You have the following constraints:
 *
 * (1) Only one disk can be moved at a time.
 * (2) A disk is slid off the top of one tower onto another tower.
 * (3) A disk cannot be placed on top of a smaller disk.
 *
 * Write a program to move the disks from the first tower to the last using stacks.
 *
 */
public class Task_6 {

    public static void main(String[] args) {
        LinkedList<Integer> tower_1 = new LinkedList<>();
        LinkedList<Integer> tower_2 = new LinkedList<>();
        LinkedList<Integer> tower_3 = new LinkedList<>();

        for (int n = 1; n < 6; n++) {
            tower_1.addLast(n);
        }

        System.out.println("Tower 1:");
        System.out.println(tower_1);

        System.out.println("Tower 2:");
        System.out.println(tower_2);

        System.out.println("Tower 3:");
        System.out.println(tower_3);

        solve(tower_1, tower_2, tower_3);

        System.out.println("========");
        System.out.println("Tower 1:");
        System.out.println(tower_1);

        System.out.println("Tower 2:");
        System.out.println(tower_2);

        System.out.println("Tower 3:");
        System.out.println(tower_3);
    }

    private static void solve(LinkedList<Integer> tower_1, LinkedList<Integer> tower_2, LinkedList<Integer> tower_3) {
        move(tower_1, tower_3, tower_2, tower_1.size());
    }

    private static void move(LinkedList<Integer> from, LinkedList<Integer> to, LinkedList<Integer> buf, int n) {
        if (n <= 0) return;

        // move all elements except last to buf tower
        move(from, buf, to, n - 1);
        // move last element to destination
        moveTop(from, to);
        // move everything else to destination, using from as a buf
        move(buf, to, from, n - 1);
    }

    private static void moveTop(LinkedList<Integer> from, LinkedList<Integer> to) {
        to.addLast(from.removeLast());
    }
}
