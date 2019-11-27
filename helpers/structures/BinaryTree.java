package structures;

// All internal structures are public because thea are heavily used in different algorithms
public class BinaryTree {
    public TreeNode root;

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public String toString() {
            StringBuilder buffer = new StringBuilder(50);
            print(buffer, "", "");
            return buffer.toString();
        }

        private void print(StringBuilder buffer, String prefix, String childrenPrefix) {
            buffer.append(prefix);
            buffer.append(value);
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
        root = put(root, key);
    }

    private TreeNode put(TreeNode treeNode, int key) {
        if (treeNode == null) {
            return new TreeNode(key);
        }

        if (treeNode.value == key) return treeNode;
        if (key < treeNode.value) {
            treeNode.left = put(treeNode.left, key);
        } else {
            treeNode.right = put(treeNode.right, key);
        }

        return treeNode;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (root != null) {
            result.append(root.toString());
        } else {
            result.append("_");
        }
        return result.toString();
    }
}
