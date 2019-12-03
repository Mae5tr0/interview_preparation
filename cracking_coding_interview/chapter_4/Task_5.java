package chapter_4;

import structures.BinaryTree;

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
        System.out.println("Valid BST: " + isBST2(tree.root));

        System.out.println();

        // building invalid binary tree
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(7);
        root.left = new BinaryTree.TreeNode(4);
        root.right = new BinaryTree.TreeNode(8);
        root.left.left = new BinaryTree.TreeNode(9);
        System.out.print(root);
        System.out.println("Valid BST: " + isBST(root));
        System.out.println("Valid BST: " + isBST2(root));
    }


    // max - min
    public static boolean isBST(BinaryTree.TreeNode rootNode) {
        return checkBSTMinMax(rootNode, null, null);
    }

    private static boolean checkBSTMinMax(BinaryTree.TreeNode current, Integer min, Integer max) {
        if (current == null) return true;

        if ((min != null && current.value <= min) || (max != null && current.value > max)) return false;

        return checkBSTMinMax(current.left, min, current.value) && checkBSTMinMax(current.right, current.value, max);
    }

    // in-order traversal
    public static boolean isBST2(BinaryTree.TreeNode rootNode) {
        return checkBST(rootNode);
    }

    private static BinaryTree.TreeNode prev;

    private static boolean checkBST(BinaryTree.TreeNode current) {
        if (current == null) return true;

        if (!checkBST(current.left)) return false;

        if (prev != null && current.value <= prev.value) return false;
        prev = current;

        return checkBST(current.right);
    }
}

// #35, #57, #86, #113, #128