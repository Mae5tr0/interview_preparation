package chapter_4;

import structures.BinaryTree;

/**
 * Minimal Tree
 *
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        int elementsCount = 9;
        int[] array = new int[elementsCount];
        for (int i = 0; i < elementsCount; i++) {
            array[i] = i;
        }

        BinaryTree tree = new BinaryTree();
        insertToTree(0, array.length - 1, tree, array);

        System.out.println(tree);

        BinaryTree.TreeNode rootTreeNodeBST = createMinimalBST(array, 0, array.length - 1);
        System.out.println(rootTreeNodeBST);
    }

    // Complexity: O(n)
    private static void insertToTree(int lo, int hi, BinaryTree tree, int[] array) {
        if (lo == hi) {
            tree.put(array[lo]);
            return;
        }
        int mid = (hi + lo) / 2;
        tree.put(array[mid]);

        if (mid - 1 >= lo) insertToTree(lo, mid - 1, tree, array);
        if (mid + 1 <= hi) insertToTree(mid + 1, hi, tree, array);
    }

    // Building tree directly
    private static BinaryTree.TreeNode createMinimalBST(int[] array, int lo, int hi) {
        if (hi < lo) return null;

        int mid = (hi + lo) / 2;
        BinaryTree.TreeNode treeNode = new BinaryTree.TreeNode(array[mid]);
        treeNode.left = createMinimalBST(array, lo, mid - 1);
        treeNode.right = createMinimalBST(array, mid + 1, hi);

        return treeNode;
    }
}
