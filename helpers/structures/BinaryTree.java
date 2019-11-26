package structures;

public class BinaryTree {
//    private int height = 0;
//    private Node root;
//
//    private static class Node {
//        private Node left;
//        private Node right;
//        private int key;
//        private int distance;
//
//        public Node(int key, int distance) {
//            this.key = key;
//            this.distance = distance;
//        }
//
//        public String toString() {
//            StringBuilder buffer = new StringBuilder(50);
//            print(buffer, "", "");
//            return buffer.toString();
//        }
//
//        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
//            buffer.append(prefix);
//            buffer.append(key);
//            buffer.append('\n');
//            if (left != null && right != null) {
//                left.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
//                right.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
//            } else {
//                left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
//                right.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
//            }
//        }
//    }
//
//    public void put(int key) {
//        root = put(root, key, 0);
//    }
//
//    private Node put(Node node, int key, int distance) {
//        if (node == null) {
//            if (distance > height) height = distance;
//            return new Node(key, distance);
//        }
//
//        if (node.key < key) {
//            node.left = put(node.left, key, distance + 1);
//        } else {
//            node.right = put(node.right, key, distance + 1);
//        }
//
//        return node;
//    }
//
//    public int getHeight() {
//        return height;
//    }
}
