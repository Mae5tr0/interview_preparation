package challenges;

import structures.BinaryTree;

public class TreeHeightOfBinaryTree {
    public static void main(String[] args) {
        //int[] input = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15, 18};  // false
        int[] input = {3, 5, 2, 1, 4, 6, 7};  // false

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }

        System.out.println(tree);
        System.out.println(height(tree.root));
    }

    public static int height(BinaryTree.TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
