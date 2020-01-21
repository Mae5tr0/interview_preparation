package challenges;

import utils.Arrays;

import java.util.LinkedList;

public class SwapNodesAlgo {
    static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[][] indexes = {
            {2, 3},
            {4, 5},
            {6, -1},
            {-1, 7},
            {8, 9},
            {10, 11},
            {12, 13},
            {-1, 14},
            {-1, -1},
            {15, -1},
            {16, 17},
            {-1, -1},
            {-1, -1},
            {-1, -1},
            {-1, -1},
            {-1, -1},
            {-1, -1},
        };

        int[] queries = {2, 3};

        int[][] log = swapNodes(indexes, queries);

        Arrays.printMatrix(log);
    }

    static int[][] swapNodes(int[][] indexes, int[] queries) {
        Node root = buildTree(indexes);

        int[][] result = new int[queries.length][indexes.length];

        int index = 0;
        for (int query : queries) {
            swap(root, 1, query);
            LinkedList<Integer> nodes = new LinkedList<>();
            inOrderTraversal(root, nodes);

            result[index++] = toIntArray(nodes);
        }

        return result;
    }

    public static void swap(Node node, int depth, int k) {
        if (node == null) return;

        if (depth % k == 0) {
            Node buf = node.left;
            node.left = node.right;
            node.right = buf;
        }

        swap(node.left, depth + 1, k);
        swap(node.right, depth + 1, k);
    }

    public static void inOrderTraversal(Node node, LinkedList<Integer> nodes) {
        if (node == null) return;

        inOrderTraversal(node.left, nodes);
        nodes.addLast(node.val);
        inOrderTraversal(node.right, nodes);
    }

    static public Node buildTree(int[][] indexes) {
        Node root = new Node(1);

        LinkedList<Node> curLevel = new LinkedList<Node>();
        curLevel.push(root);
        LinkedList<Node> nextLevel = new LinkedList<Node>();

        for (int[] nodes : indexes) {
            if (curLevel.isEmpty()) {
                curLevel = nextLevel;
                nextLevel = new LinkedList<Node>();
            }
            Node parent = curLevel.remove();
            if (nodes[0] != -1) {
                Node node = new Node(nodes[0]);
                parent.left = node;
                nextLevel.add(node);
            }
            if (nodes[1] != -1) {
                Node node = new Node(nodes[1]);
                parent.right = node;
                nextLevel.add(node);
            }
        }

        return root;
    }

    static int[] toIntArray(LinkedList<Integer> list){
        int[] ret = new int[list.size()];
        for(int i = 0;i < ret.length;i++)
            ret[i] = list.get(i);
        return ret;
    }
}
