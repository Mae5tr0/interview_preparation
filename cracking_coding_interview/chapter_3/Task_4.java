package chapter_3;


import structures.LinkedList;

/**
 * Queue via Stacks
 *
 * Implement a MyQueue class which implements a queue using two stacks.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
        MyQueue2 queue = new MyQueue2();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);

        System.out.println(queue.remove()); // 3
        System.out.println(queue.remove()); // 2
        queue.add(5);
        System.out.println(queue.remove()); // 1

        System.out.println(queue);
    }

    // Complexity: Remove -> O(1); Add -> O(n^2)
    private static class MyQueue {
        private LinkedList<Integer> left = new LinkedList<>();
        private LinkedList<Integer> right = new LinkedList<>();

        public void add(int value) {
            left.push(value);
        }

        public int remove() {
            shiftEntries(left, right);
            int result = right.pop();
            shiftEntries(right, left);

            return result;
        }

        private void shiftEntries(LinkedList<Integer> from, LinkedList<Integer> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // Complexity: Remove -> O(n); Add -> O(1)
    private static class MyQueue2 {
        private LinkedList<Integer> left = new LinkedList<>();
        private LinkedList<Integer> right = new LinkedList<>();

        public void add(int value) {
            left.push(value);
        }

        public int remove() {
            if (right.isEmpty()) shiftEntries(left, right);

            return right.pop();
        }

        private void shiftEntries(LinkedList<Integer> from, LinkedList<Integer> to) {
            while (!from.isEmpty()) {
                to.push(from.pop());
            }
        }

        @Override
        public String toString() {
            return "MyQueue{" +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
