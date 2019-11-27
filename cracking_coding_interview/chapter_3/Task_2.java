package chapter_3;


import structures.LinkedList;
import structures.Pair;

import java.util.EmptyStackException;

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
        MinStack2 stack = new MinStack2();

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

    // Complexity: all operations O(1), Memory: 2n -> O(n)
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

            list.push(new Pair<>(value, prevMin));
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

    // Complexity: O(1), Memory: n + a -> O(n), where a is min count
    private static class MinStack2{
        private LinkedList<Integer> list;
        private LinkedList<Integer> min;

        public MinStack2() {
            list = new LinkedList<>();
            min = new LinkedList<>();
        }

        public void push(int value) {
            list.push(value);
            if (min.isEmpty()) min.push(value);
            if (value < min.peek()) min.push(value);
        }

        public int pop() {
            if (min.peek().equals(list.peek())) min.pop();

            return list.pop();
        }

        public int min() {
            if (min.isEmpty()) throw new EmptyStackException();

            return min.peek();
        }

        @Override
        public String toString() {
            return "ThreeStacks{list=" + list + '}';
        }
    }
}
