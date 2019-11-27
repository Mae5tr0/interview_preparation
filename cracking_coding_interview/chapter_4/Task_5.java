package chapter_4;

import structures.BinaryTree;
import structures.Pair;

/**
 * Validate BST
 *
 * Implement a function to check if a binary tree is a binary search tree.
 *
 */
public class Task_5 {

    public static void main(String[] args) {
        int[] input = {5, 4, 7, 9, 10, 3, 6}; // true

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        System.out.print(tree);
        System.out.println("Valid BST: " + isBST(tree.root));

        System.out.println();

        // building invalid binary tree
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(7);
        root.left = new BinaryTree.TreeNode(4);
        root.right = new BinaryTree.TreeNode(8);
        root.left.left = new BinaryTree.TreeNode(9);
        System.out.print(root);
        System.out.println("Valid BST: " + isBST(root));
    }


    // max - min
    public static boolean isBST(BinaryTree.TreeNode node) {
        return false;
    }

    // in-order traversal
    public static boolean isBST2(BinaryTree.TreeNode node) {
        return false;
    }
}
