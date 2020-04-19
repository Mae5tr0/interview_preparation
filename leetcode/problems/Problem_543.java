package problems;

/**
 * (Diameter of Binary Tree)[https://leetcode.com/problems/diameter-of-binary-tree/]
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 */
public class Problem_543 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static class Pair {
        int maxDepth;
        int maxDiameter;

        Pair(int diameter, int depth) { maxDiameter = diameter; maxDepth = depth; }
    }

    public class Solution {
        int result;

        public int diameterOfBinaryTree(TreeNode root) {
            result = 1;
            
            depth(root);

            return result;
        }

        public int depth(TreeNode node) {
            if (node == null) return 0;

            int L = depth(node.left);
            int R = depth(node.right);
            result = Math.max(result, L + R + 1);

            return Math.max(L, R) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(diameterOfBinaryTree(node1));
    }

    public static int diameterOfBinaryTree(TreeNode node) {
        if (node == null) return 0;

        Pair left = maxDiameter(node.left);
        Pair right = maxDiameter(node.right);

        return Math.max(left.maxDiameter, Math.max(right.maxDiameter, left.maxDepth + right.maxDepth));
    }

    public static Pair maxDiameter(TreeNode node) {
        if (node == null) return new Pair(0, 0);

        Pair left = maxDiameter(node.left);
        Pair right = maxDiameter(node.right);

        return new Pair(
                Math.max(left.maxDiameter, Math.max(right.maxDiameter, left.maxDepth + right.maxDepth)),
                1 + Math.max(left.maxDepth, right.maxDepth)
        );
    }
}