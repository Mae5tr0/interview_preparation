package chapter_4;

import structures.BinaryTree;
import structures.LinkedList;

import java.util.Arrays;

/**
 * BST Sequences
 *
 * A binary search tree was created by traversing through an array from left to right and inserting each element.
 * Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree
 *
 */
public class Task_9 {

    public static void main(String[] args) {
        int[] input = {2, 1, 4, 5, 3};
//        int[] input = {2, 1, 3};

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        System.out.println(tree);

        for (int[] el : permutations(tree.root)) {
            System.out.println(Arrays.toString(el));
        }
    }

    public static LinkedList<int[]> permutations(BinaryTree.TreeNode node) {
        if (node == null) return new LinkedList<>();

        LinkedList<int[]> leftPermutations = permutations(node.left);
        LinkedList<int[]> rightPermutations = permutations(node.right);

        // leaf
        if (leftPermutations.isEmpty() && rightPermutations.isEmpty()) {
            LinkedList<int[]> result = new LinkedList<>();
            int[] leaf = {node.value};
            result.addFirst(leaf);
            return result;
        }
        if (leftPermutations.isEmpty()) {
            return appendValue(node.value, leftPermutations);

        }
        if (rightPermutations.isEmpty()) {
            return appendValue(node.value, rightPermutations);
        }

        LinkedList<int[]> leftToRight = appendValue(node.value, multiplyLists(leftPermutations, rightPermutations));
        LinkedList<int[]> rightToLeft = appendValue(node.value, multiplyLists(rightPermutations, leftPermutations));

        LinkedList<int[]> result = new LinkedList<>();
        for (int[] el : leftToRight) {
            result.push(el);
        }
        for (int[] el : rightToLeft) {
            result.push(el);
        }

        return result;
    }

    private static LinkedList<int []> appendValue(int value, LinkedList<int[]> list) {
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] el : list) {
            int[] item = new int[el.length + 1];
            item[0] = value;
            System.arraycopy(el, 0, item, 1, el.length);
            result.push(item);
        }
        return result;
    }

    private static LinkedList<int[]> multiplyLists(LinkedList<int[]> left, LinkedList<int[]> right) {
        LinkedList<int[]> result = new LinkedList<>();

        for (int[] l : left) {
            for (int[] r : right) {
                int[] item = new int[l.length + r.length];
                System.arraycopy(l, 0, item, 0, l.length);
                System.arraycopy(r, 0, item, l.length, r.length);
                result.push(item);
            }
        }

        return result;
    }
}
