package chapter_4;

import structures.BinaryTree;
import structures.LinkedList;

import java.util.Iterator;

/**
 * Check Subtree
 *
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
 * algorithm to determine if T2 is a subtree of Tl.
 * A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identical to T2.
 * That is, if you cut off the tree at node n, the two trees would be identical.
 *
 */
public class Task_10 {

    public static void main(String[] args) {
        int[] input1 = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15, 18};
        BinaryTree t1 = new BinaryTree();
        for (int el : input1) {
            t1.put(el);
        }
        System.out.println(t1);

        int[] input2 = {9, 8, 11, 15, 18};
        BinaryTree t2 = new BinaryTree();
        for (int el : input2) {
            t2.put(el);
        }
        System.out.println(t2);

        int[] input3 = {9, 8, 11, 15};
        BinaryTree t3 = new BinaryTree();
        for (int el : input3) {
            t3.put(el);
        }
        System.out.println(t3);

        System.out.println(isSubtree(t1.getNode(9), t2.root));  // true
        System.out.println(isSubtree(t1.getNode(9), t3.root));  // false

        System.out.println(isSubtree2(t1.root, t2.root));  // true
        System.out.println(isSubtree2(t1.root, t3.root));  // false
    }

    private static boolean isSubtree2(BinaryTree.TreeNode tree, BinaryTree.TreeNode subtree) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(tree, string1);
        getOrderString(subtree, string2);

        System.out.println(string1);
        System.out.println(string2);

        return string1.indexOf(string2.toString()) != -1;
    }

    private static void getOrderString(BinaryTree.TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append('X').append(' ');
            return;
        }

        sb.append(node.value).append(' ');
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }

    private static boolean isSubtree(BinaryTree.TreeNode tree, BinaryTree.TreeNode subtree) {
        Iterator<Integer> treePostorder = postorder(tree).iterator();
        Iterator<Integer> subtreePostorder = postorder(subtree).iterator();

        boolean result = true;
        while (subtreePostorder.hasNext()) {
            if (!treePostorder.hasNext()) {
                result = false;
                break;
            }
            if (!treePostorder.next().equals(subtreePostorder.next())) {
                result = false;
                break;
            }
        }
        if (treePostorder.hasNext()) result = false;

        return result;
    }

    // Iterator can be lazy, so we will not store all nodes in linked list
    private static Iterable<Integer> postorder(BinaryTree.TreeNode node) {
        LinkedList<Integer> result = new LinkedList<>();

        postOrderTraversal(result, node);

        return result;
    }

    private static void postOrderTraversal(LinkedList<Integer> order, BinaryTree.TreeNode node) {
        if (node == null) return;

        postOrderTraversal(order, node.left);
        postOrderTraversal(order, node.right);
        order.push(node.value);
    }
}
