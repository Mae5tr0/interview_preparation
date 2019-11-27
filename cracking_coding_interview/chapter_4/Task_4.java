package chapter_4;

import structures.BinaryTree;
import structures.Pair;

/**
 * Check Balanced
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that the heights of the two subtrees of any node
 * never differ by more than one.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
//        int[] input = {5, 4, 7, 9, 10, 3, 6}; // true
        int[] input = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15, 18};  // false

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }

        System.out.println(tree);
        System.out.println("Balanced: " + isBalanced(tree));
    }

    // Complexity: O(n)
    public static boolean isBalanced(BinaryTree tree) {
        return calcBalance(tree.root).getFirst();
    }

    private static Pair<Boolean, Integer> calcBalance(BinaryTree.TreeNode node) {
        if (node == null) {
            return new Pair<>(true, 0);
        }

        Pair<Boolean, Integer> leftBalance = calcBalance(node.left);
        if (!leftBalance.getFirst())
            return new Pair<>(false, Integer.MIN_VALUE);
        Pair<Boolean, Integer> rightBalance = calcBalance(node.right);
        if (!rightBalance.getFirst())
            return new Pair<>(false, Integer.MIN_VALUE);
        if (Math.abs(leftBalance.getLast() - rightBalance.getLast()) > 1)
            return new Pair<>(false, Integer.MIN_VALUE);

        return new Pair<>(true, Math.max(leftBalance.getLast(), rightBalance.getLast()) + 1);
    }
}
