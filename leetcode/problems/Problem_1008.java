package problems;

/**
 * (Construct Binary Search Tree from Preorder Traversal)[https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/]
 */
public class Problem_1008 {
    class Solution {
        int i = 0;

        public TreeNode bstFromPreorder(int[] A) {
            return bstFromPreorder(A, Integer.MAX_VALUE);
        }

        public TreeNode bstFromPreorder(int[] A, int bound) {
            if (i == A.length || A[i] > bound) return null;

            TreeNode root = new TreeNode(A[i++]);
            root.left = bstFromPreorder(A, root.val);
            root.right = bstFromPreorder(A, bound);

            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        TreeNode result = bstFromPreorder(new int[]{8,5,1,7,10,12});
        System.out.println(result);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for (int num : preorder) {
            addNode(root, num);
        }

        return root;
    }

    public static TreeNode addNode(TreeNode parent, int value) {
        if (parent == null) return new TreeNode(value);

        if (value < parent.val) parent.left = addNode(parent.left, value);
        if (value > parent.val) parent.right = addNode(parent.right, value);

        return parent;
    }
}