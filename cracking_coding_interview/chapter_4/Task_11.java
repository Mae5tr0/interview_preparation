package chapter_4;

import java.util.Random;

/**
 * Random Node
 *
 * You are implementing a binary tree class from scratch which, in addition to insert, find, and delete,
 * has a method getRandomNode() which returns a random node from the tree.
 * All nodes should be equally likely to be chosen.
 * Design and implement an algorithm for getRandomNode, and explain how you would implement the rest of the methods.
 *
 */
public class Task_11 {

    public static void main(String[] args) {
        int[] input = {5, 4, 7, 9, 0, 3, 6, 8, 11, 15};
        BinaryTree tree = new BinaryTree();
        for (int el : input) {
            tree.put(el);
        }
        System.out.println(tree);

        int[] stats = new int[16]; // max tree item

        int repeats = 10000;
        for (int i = 0; i < repeats; i++) {
            stats[tree.getRandomNode().value] = stats[tree.getRandomNode().value] + 1;
        }

        for (int i = 0; i < stats.length; i++) {
            if (stats[i] > 0) {
                System.out.println(i + " -> " + stats[i] /(double) repeats);
            }
        }
    }

    private static class BinaryTree {
        public TreeNode root;
        private Random r = new Random();

        public static class TreeNode {
            public TreeNode left;
            public TreeNode right;
            public int value;

            public int leftChildren = 0;
            public int rightChildren = 0;

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
                buffer.append(value).append('(').append(leftChildren).append("|.|").append(rightChildren).append(')');
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

        public TreeNode getRandomNode() {
            return getRandomNode(root);
        }

        private TreeNode getRandomNode(TreeNode node) {
            int random = r.nextInt(node.leftChildren + node.rightChildren + 2); // 1 for node itself, 1 + for inbound

            if (random < node.leftChildren) return getRandomNode(node.left);
            if (random > node.leftChildren + 1) return getRandomNode(node.right);
            return node;
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
                treeNode.leftChildren++;
            } else {
                treeNode.right = put(treeNode.right, key);
                treeNode.rightChildren++;
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

}
