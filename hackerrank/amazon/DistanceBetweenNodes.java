package amazon;

import java.util.LinkedList;
import java.util.List;

public class DistanceBetweenNodes {
    public static void main(String[] args) {
        LinkedList<Integer> nodes = new LinkedList<>();
//        nodes.add(5);
//        nodes.add(6);
//        nodes.add(3);
//        nodes.add(1);
//        nodes.add(2);
//        nodes.add(4);

        nodes.add(5);
        nodes.add(9);
        nodes.add(7);
        nodes.add(5);
        nodes.add(3);
        nodes.add(1);

        System.out.println(foo(nodes, 7, 20)); // 3
    }

    /*
     * Complete the 'foo' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY values
     *  2. INTEGER node1
     *  3. INTEGER node2
     */

    public static int foo(List<Integer> values, int node1, int node2) {
        Node root = null;
        for (Integer value : values) {
           root = insertNode(root, value);
        }

        return distanceBetweenNodes(root, node1, node2);
    }

    static int distanceFromRoot(Node root, int a) {
        if (root == null) return -1;
        int dist = 0;

        if (root.value == a) {
            return dist;
        } else if (root.value > a) {
            dist = distanceFromRoot(root.left, a);
            if (dist != -1) return dist + 1;
            return -1;
        }
        dist = distanceFromRoot(root.right, a);
        if (dist != -1) return dist + 1;
        return -1;
    }

    static int distanceBetweenNodes(Node root, int a, int b) {
        if (root == null) return 0;

        if (root.value > a && root.value > b) return distanceBetweenNodes(root.left, a, b);
        if (root.value < a && root.value < b) return distanceBetweenNodes(root.right, a, b);

        if (root.value >= a && root.value <= b) {
            int distanceA = distanceFromRoot(root, a);
            int distanceB = distanceFromRoot(root, b);
            if (distanceA != -1 && distanceB != -1) {
                return distanceA + distanceB;
            } else {
                return -1;
            }
        }

        return 0;
    }

    public static class Node {
        public Node left, right;
        public int value;
    }

    public static Node insertNode(Node root, int value) {
        if (root == null) {
            root = newNode(value);
        } else if (root.value > value) {
            root.left = insertNode(root.left, value);
        } else if (root.value < value) {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    static Node newNode(int value) {
        Node result = new Node();
        result.value = value;
        result.left = null;
        result.right = null;

        return result;
    }

}
