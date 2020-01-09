package chapter_10;


/**
 * Rank from Stream
 *
 * Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x
 * (the number of values less than or equal to x). Implement the data structures and algorithms to support these operations.
 * That is, implement the method track(int x), which is called when each number is generated, and the method getRankOfNumber(int x),
 * which returns the number of values less than or equal to x(not including x itself).
 *
 */
public class Task_10 {

    public static void main(String[] args) {
        int[] stream = {5, 1, 4, 4, 5, 9, 7, 13, 3};

        StreamRank streamRank = new StreamRank();
        for (int el : stream) {
            streamRank.track(el);
        }

        System.out.println(streamRank.getRankOfNumber(1)); // 0
        System.out.println(streamRank.getRankOfNumber(3)); // 1
        System.out.println(streamRank.getRankOfNumber(4)); // 3
        System.out.println(streamRank.getRankOfNumber(6)); // -1
    }

    static class StreamRank {
        RankNode root;

        public StreamRank() {
        }

        public void track(int x) {
            root = insert(root, x);
        }

        public int getRankOfNumber(int x) {
            return inOrderTraversal(root, x);
        }

        private RankNode insert(RankNode node, int value) {
            if (node == null) {
                return new RankNode(value);
            }

            if (node.value == value) {
                node.leftSize++;
                return node;
            } else if (node.value > value) {
                node.leftSize++;
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }

            return node;
        }

        private int inOrderTraversal(RankNode node, int value) {
            if (node == null) return -1;

            if (node.value == value) return node.leftSize;
            else if (value > node.value) {
                int rank = inOrderTraversal(node.right, value);
                return rank == -1 ? -1 : rank + node.leftSize + 1;
            }
            else {
                return inOrderTraversal(node.left, value);
            }
        }
    }

    public static class RankNode {
        public RankNode left, right;
        public int leftSize = 0;
        public int value;

        public RankNode(int value) {
            this.value = value;
        }
    }
}