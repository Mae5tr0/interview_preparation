package problems;

/**
 * (Min Stack)[https://leetcode.com/problems/min-stack/]
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 *      push(x) -- Push element x onto stack.
 *      pop() -- Removes the element on top of the stack.
 *      top() -- Get the top element.
 *      getMin() -- Retrieve the minimum element in the stack.
 *
 */
public class Problem_155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());  // -3
        minStack.pop();
        System.out.println(minStack.top());    // 0
        System.out.println(minStack.getMin()); // -2
    }

    static class MinStack {
        class Node {
            Node next;
            int value;
            int minValue;
        }

        Node head;

        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node();
                head.value = x;
                head.minValue = x;
            } else {
                Node node = new Node();
                node.next = head;
                node.value = x;
                node.minValue = Math.min(head.minValue, x);
                head = node;
            }
        }

        public void pop() {
            if (head == null) throw new IllegalStateException();
            head = head.next;
        }

        public int top() {
            if (head == null) throw new IllegalStateException();

            return head.value;
        }

        public int getMin() {
            return head.minValue;
        }
    }
}