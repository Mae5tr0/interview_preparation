package challenges;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 3, 1, 7, 6};
        Node root = null;

        for (int i : input) {
            root = insert(root, i);
        }

        System.out.println(lca(root, 1, 7).data); // 4
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) return null;

        if (root.data < v1 && root.data < v2) return lca(root.right, v1, v2);
        if (root.data > v1 && root.data > v2) return lca(root.left, v1, v2);
        return root;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
}
