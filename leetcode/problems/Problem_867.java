package problems;

/**
 *  (Merge Two Binary Trees)[https://leetcode.com/problems/merge-two-binary-trees/]
 *
 *  Given two binary trees and imagine that when you put one of them to cover the other,
 *  some nodes of the two trees are overlapped while the others are not.
 *
 *  You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,
 *  then sum node values up as the new value of the merged node.
 *  Otherwise, the NOT null node will be used as the node of new tree.
 *
 */
public class Problem_867 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
    }

    static public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        t1 = t1 == null ? new TreeNode(0) : t1;
        t2 = t2 == null ? new TreeNode(0) : t2;

        TreeNode result = new TreeNode(t1.val + t2.val);
        result.left = mergeTrees(t1.left, t2.left);
        result.right = mergeTrees(t1.right, t2.right);

        // Another approach, we save memory for garbage collection
//        if (t2 == null) {
//            result = new TreeNode(t1.val);
//            result.left = mergeTrees(t1.left, null);
//            result.right = mergeTrees(t1.right, null);
//        } else if (t1 == null) {
//            result = new TreeNode(t2.val);
//            result.left = mergeTrees(t2.left, null);
//            result.right = mergeTrees(t2.right, null);
//        } else {
//            result = new TreeNode(t1.val + t2.val);
//            result.left = mergeTrees(t1.left, t2.left);
//            result.right = mergeTrees(t1.right, t2.right);
//        }

        return result;
    }


}
