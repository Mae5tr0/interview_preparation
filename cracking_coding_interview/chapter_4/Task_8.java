package chapter_4;

import structures.BinaryTree;

/**
 * First Common Ancestor
 *
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 *
 */
public class Task_8 {

    public static void main(String[] args) {
        int[] input = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15, 18};

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        System.out.println(tree);

        BinaryTree.TreeNode ancestor = findAncestor(tree.getNode(6), tree.getNode(15), tree.root);
        System.out.println(ancestor.value); // 7
    }

    // Complexity: l + l + l -> 3l -> O(l), Memory: O(l) - where l is tree depth
    public static BinaryTree.TreeNode findAncestor(BinaryTree.TreeNode a, BinaryTree.TreeNode b, BinaryTree.TreeNode root) {
        String pathA = pathFromRoot(a);
        String pathB = pathFromRoot(b);

        BinaryTree.TreeNode result = root;
        for (int i = 0; i < Math.min(pathA.length(), pathB.length()); i++) {
            if (pathA.charAt(i) != pathB.charAt(i)) break;

            if (pathA.charAt(i) == 'l') {
                result = result.left;
            } else {
                result = result.right;
            }
        }

        return result;
    }

    private static String pathFromRoot(BinaryTree.TreeNode node) {
        StringBuilder path = new StringBuilder();
        BinaryTree.TreeNode parent = node.parent;
        while (parent != null) {
            if (parent.left == node) {
                path.append('l');
            } else { path.append('r'); }
            parent = parent.parent;
        }

        return path.reverse().toString();
    }
}
