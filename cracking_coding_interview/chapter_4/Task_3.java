package chapter_4;

import structures.BinaryTree;
import structures.LinkedList;
import java.util.ArrayList;

/**
 * List of Depths
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 */
public class Task_3 {
    public static void main(String[] args) {
        int[] input = {5, 4, 7, 9, 0, 3, 6, 8};

        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }

        System.out.println(tree);
        System.out.println(listOfDepths(tree));
    }

    // Complexity: O(n), Memory: O(n)
    public static ArrayList<LinkedList<Integer>> listOfDepths(BinaryTree tree) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        processLevelTree(tree.root, 0, result);

        return result;
    }

    private static void processLevelTree(
            BinaryTree.TreeNode node, int level,
            ArrayList<LinkedList<Integer>> arrayList
    ) {
        if (node == null) return;

        LinkedList<Integer> list;
        if (arrayList.size() == level) {
            list = new LinkedList<>();
            arrayList.add(level, list);
        } else { list = arrayList.get(level); }
        list.push(node.value);

        processLevelTree(node.left, level + 1, arrayList);
        processLevelTree(node.right, level + 1, arrayList);
    }
}
