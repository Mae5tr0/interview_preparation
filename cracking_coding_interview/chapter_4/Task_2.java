package chapter_4;

/**
 * Minimal Tree
 *
 * Given a sorted (increasing order) array with unique integer elements,
 * write an algorithm to create a binary search tree with minimal height.
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        int elementsCount = 9;
        int[] array = new int[elementsCount];
        for (int i = 0; i < elementsCount; i++) {
            array[i] = i;
        }

        BinaryTree tree = new BinaryTree();
        insertToTree(0, array.length - 1, tree, array);

        System.out.println(tree);
    }

    // Complexity: O(n)
    private static void insertToTree(int lo, int hi, BinaryTree tree, int[] array) {
        if (lo == hi) {
            tree.put(array[lo]);
            return;
        }
        int mid = (hi + lo) / 2;
        tree.put(array[mid]);

        if (mid - 1 >= lo) insertToTree(lo, mid - 1, tree, array);
        if (mid + 1 <= hi) insertToTree(mid + 1, hi, tree, array);
    }

    public static class BinaryTree {
        private int height = 0;
        private Node root;

        private static class Node {
            private Node left;
            private Node right;
            private int key;

            public Node(int key) {
                this.key = key;
            }

            public String toString() {
                StringBuilder buffer = new StringBuilder(50);
                print(buffer, "", "");
                return buffer.toString();
            }

            private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
                buffer.append(prefix);
                buffer.append(key);
                buffer.append('\n');
                if (left != null && right != null) {
                    left.print(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
                    right.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                } else {
                    if (left != null)
                        left.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                    if (right != null)
                        right.print(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
                }
            }
        }

        public void put(int key) {
            root = put(root, key, 1);
        }

        private Node put(Node node, int key, int distance) {
            if (node == null) {
                if (distance > height) height = distance;
                return new Node(key);
            }

            if (node.key < key) {
                node.left = put(node.left, key, distance + 1);
            } else {
                node.right = put(node.right, key, distance + 1);
            }

            return node;
        }

        public int getHeight() {
            return height;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            if (root != null) {
                result.append(root.toString()).append('\n');
            } else {
                result.append("_\n");
            }
            result.append("Height: ").append(height);
            return result.toString();
        }
    }
}
