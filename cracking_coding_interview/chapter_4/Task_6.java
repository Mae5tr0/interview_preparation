package chapter_4;

import structures.BinaryTree;

/**
 * Successor
 *
 * Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
 * You may assume that each node has a link to its parent.
 *
 */
public class Task_6 {

    public static void main(String[] args) {
        int[] input = {6, 4, 7, 9, 10, 2, 1, 5};

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        System.out.print(tree);

        BinaryTree.TreeNode node = tree.getNode(5);
        System.out.println(node);
        System.out.println(successor(node));
    }


    public static BinaryTree.TreeNode successor(BinaryTree.TreeNode node) {
        if (node.right != null) return leftMostChild(node.right);

        BinaryTree.TreeNode parent = node.parent;
        BinaryTree.TreeNode child = node;
        while (parent != null) {
            if (parent.right == child) {
                child = parent;
                parent = parent.parent;
            } else {
                return parent;
            }
        }

        return null;
    }

    private static BinaryTree.TreeNode leftMostChild(BinaryTree.TreeNode node) {
        if (node.left != null) return leftMostChild(node.left);

        return node;
    }

}
