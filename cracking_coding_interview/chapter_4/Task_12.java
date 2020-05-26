package chapter_4;

import structures.BinaryTree;
import structures.LinkedList;

import java.util.HashMap;

/**
 * Paths with Sum
 *
 * You are given a binary tree in which each node contains an integer value (which might be positive or negative).
 * Design an algorithm to count the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf,
 * but it must go downwards (traveling only from parent nodes to child nodes).
 *
 */
public class Task_12 {

    public static void main(String[] args) {
        int[] input = {11, 4, 7, 9, 0, 2, 3, 6, 8, 15, 18, 1, 17, 20, 19, 10, 16, 12, 13, 18};

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        BinaryTree.TreeNode node = tree.getNode(12);
        BinaryTree.TreeNode node2 = tree.getNode(18);
        BinaryTree.TreeNode node3 = tree.getNode(17);
        BinaryTree.TreeNode node4 = tree.getNode(20);
        BinaryTree.TreeNode node5 = tree.getNode(15);
        BinaryTree.TreeNode node6 = tree.getNode(16);
        BinaryTree.TreeNode node7 = tree.getNode(10);
        node.value = -4;
        node2.value = 5;
        node3.value = -1;
        node4.value = 4;
        node5.value = 3;
        node6.value = 5;
        node7.value = -4;

        System.out.println(tree);

        // 7 9 -4
        // 3 -4 13
        // 3 5 -1 5
        // 3 5 4
        System.out.println(paths(tree.root, 12)); // 4
        System.out.println(paths2(tree.root, 12));
    }

    // Complexity: O(n^2)
    private static int paths(BinaryTree.TreeNode rootNode, int sum) {
        int result = 0;

        for (BinaryTree.TreeNode node :  preorder(rootNode)) {
            result += pathCountForSum(0, sum, node);
        }

        return result;
    }

    private static int pathCountForSum(int acc, int goal, BinaryTree.TreeNode startNode) {
        if (startNode == null) return 0;

        int cumSum = acc + startNode.value;

        if (cumSum == goal) {
            return 1;
        }

        return pathCountForSum(cumSum, goal, startNode.left) + pathCountForSum(cumSum, goal, startNode.right);
    }

    private static LinkedList<BinaryTree.TreeNode> preorder(BinaryTree.TreeNode root) {
        LinkedList<BinaryTree.TreeNode> result = new LinkedList<>();

        preorderTraversal(result, root);

        return result;
    }


    private static void preorderTraversal(LinkedList<BinaryTree.TreeNode> order, BinaryTree.TreeNode node) {
        if (node == null) return;

        order.push(node);
        preorderTraversal(order, node.left);
        preorderTraversal(order, node.right);
    }

    // Complexity O(n)
    private static int paths2(BinaryTree.TreeNode rootNode, int targetSum) {
        return countPathsWithSumFromNode(new HashMap<Integer, Integer>(), targetSum, 0, rootNode);
    }

    private static int countPathsWithSumFromNode(HashMap<Integer, Integer> pathCount, int targetSum, int runningSum, BinaryTree.TreeNode node) {
        if (node == null) return 0;

        int runningSumAtNode = runningSum + node.value;
        int sum = runningSumAtNode - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSumAtNode == targetSum) totalPaths++;

        incrementHashTable(pathCount, runningSumAtNode, 1);
        totalPaths += countPathsWithSumFromNode(pathCount, targetSum, runningSumAtNode, node.left);
        totalPaths += countPathsWithSumFromNode(pathCount, targetSum, runningSumAtNode, node.right);
        incrementHashTable(pathCount, runningSumAtNode, -1);

        return totalPaths;
    }

    private static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}