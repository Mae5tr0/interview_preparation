package challenges;

public class IsBinaryTree {
    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 6, 1, 3, 5, 7};
        Node root = null;

        for (int i : input) {
            root = insert(root, i);
        }

        System.out.println(checkBST(root)); // true
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    static boolean checkBST(Node root) {
        if (root == null) return true;

        if (root.right != null && root.right.data < root.data) return false;
        if (root.left != null && root.left.data > root.data) return false;

        return checkBST(root.left) && checkBST(root.right);
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
