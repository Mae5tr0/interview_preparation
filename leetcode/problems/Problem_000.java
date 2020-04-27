package problems;

/**
 * ()[]
 */
public class Problem_000 {
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