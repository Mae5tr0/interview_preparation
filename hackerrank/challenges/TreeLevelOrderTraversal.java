package challenges;

import structures.BinaryTree;
import structures.LinkedList;

public class TreeLevelOrderTraversal {
    public static void main(String[] args) {
        //int[] input = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15, 18};  // false
        int[] input = {3, 5, 2, 1, 4, 6, 7};  // false

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }

        System.out.println(tree);

        levelOrder(tree.root);
    }

    private static int height(BinaryTree.TreeNode node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public static void levelOrder(BinaryTree.TreeNode root) {
        LinkedList<BinaryTree.TreeNode>[] nodesByHeight = new LinkedList[height(root)];
        for (int i = 0; i < nodesByHeight.length; i++) {
            nodesByHeight[i] = new LinkedList<>();
        }

        groupByHeight(root, 0, nodesByHeight);

        StringBuilder result = new StringBuilder();
        for (LinkedList<BinaryTree.TreeNode> list : nodesByHeight) {
            for (BinaryTree.TreeNode node : list) {
                result.append(node.value).append(" ");
            }
        }
        System.out.println(result);
    }

    private static void groupByHeight(BinaryTree.TreeNode node, int currentHeight, LinkedList<BinaryTree.TreeNode>[] nodesByHeight) {
        if (node == null) return;

        nodesByHeight[currentHeight].addLast(node);

        groupByHeight(node.left, currentHeight + 1, nodesByHeight);
        groupByHeight(node.right, currentHeight + 1, nodesByHeight);
    }
}
