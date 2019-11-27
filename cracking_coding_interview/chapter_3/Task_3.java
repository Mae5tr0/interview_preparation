package chapter_3;


import structures.LinkedList;

/**
 * Stack of Plates
 *
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structures SetOfStacks that mimic this. SetOfStacks should be composed of several stacks
 * and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack (that is,
 * pop() should return the same values as it would if there were just a single stack).
 *
 */
public class Task_3 {
    public static void main(String[] args) {
        SetOfStacks stack = new SetOfStacks(3);

        for (int i = 0; i < 7; i++) {
            stack.push(i);
        }
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }

    // Memory: O(n)
    private static class SetOfStacks {
        private int threshold;
        LinkedList<LinkedList<Integer>> stacks = new LinkedList<>();

        public SetOfStacks(int threshold) {
            this.threshold = threshold;
            stacks.push(new LinkedList<>());
        }

        public void push(int value) {
            LinkedList<Integer> stack = stacks.getLast();

            if (stack.size() + 1 > threshold) {
                stack = new LinkedList<>();
                stack.push(value);
                stacks.push(stack);
            } else {
                stack.push(value);
            }
        }

        public int pop() {
            LinkedList<Integer> stack = stacks.getLast();
            int result = stack.pop();

            if (stack.size() == 0) stacks.pop();

            return result;
        }

        @Override
        public String toString() {
            return "SetOfStacks{" +
                    "threshold=" + threshold +
                    ", stacks=" + stacks +
                    '}';
        }
    }
}
