package challenges;

public class HuffmanDecoding {
    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 6, 1, 3, 5, 7};
        Node root = null;

        for (int i : input) {
            root = insert(root, i);
        }

//        System.out.println(decode(root));
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    void decode(String s, Node root) {

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
