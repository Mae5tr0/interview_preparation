package structures;

// All internal structures are public because thea are heavily used in different algorithms
public class BinaryTree {
    public TreeNode root;

    public static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent; // required for some tasks
        public int value;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode parent) {
            this.value = value;
            this.parent = parent;
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

    public TreeNode getNode(int key) {
        return getNode(key, root);
    }

    private TreeNode getNode(int key, TreeNode node) {
        if (node == null) return null;

        if (key < node.value) return getNode(key, node.left);
        if (key > node.value) return getNode(key, node.right);

        return node;
    }

    public void put(int key) {
        root = put(root, key, null);
    }

    private TreeNode put(TreeNode treeNode, int key, TreeNode parent) {
        if (treeNode == null) {
            return new TreeNode(key, parent);
        }

        if (treeNode.value == key) return treeNode;
        if (key < treeNode.value) {
            treeNode.left = put(treeNode.left, key, treeNode);
        } else {
            treeNode.right = put(treeNode.right, key, treeNode);
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
