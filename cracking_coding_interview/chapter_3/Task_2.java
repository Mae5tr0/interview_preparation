package chapter_3;


import structures.LinkedList;
import structures.Pair;

/**
 * Stack Min
 *
 * How would you design a stack which, in addition to push and pop,
 * has a function min which returns the minimum element?
 * Push, pop and min should all operate in 0(1) time.
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(4);

        System.out.println(stack);
        System.out.println(stack.min());

        stack.push(7);
        stack.push(3);

        System.out.println(stack);
        System.out.println(stack.min());

        stack.pop();
        System.out.println(stack);
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.min());
    }

    // Complexity: all operations O(1)
    private static class MinStack {
        private LinkedList<Pair<Integer, Integer>> list;
        private Integer min;

        public MinStack() {
            list = new LinkedList<>();
        }

        public void push(int value) {
            if (min == null) min = value;

            int prevMin = min;
            if (min > value) min = value;

            list.push(new Pair(value, prevMin));
        }

        public int pop() {
            Pair<Integer, Integer> result = list.pop();
            min = result.getLast();

            return result.getFirst();
        }

        public int min() {
            return min;
        }

        @Override
        public String toString() {
            return "ThreeStacks{list=" + list + '}';
        }
    }
}
