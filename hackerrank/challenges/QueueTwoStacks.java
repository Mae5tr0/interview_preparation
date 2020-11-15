package challenges;

import java.util.Stack;

public class QueueTwoStacks {
    static class MyQueue<T> {
        Stack<T> in;
        Stack<T> out;

        public MyQueue() {
            in = new Stack<>();
            out = new Stack<>();
        }

        void enqueue(T val) {
            in.push(val);
        }

        T dequeue() {
            if (out.empty()) move();
            return out.pop();
        }

        T peek() {
            if (out.empty()) move();
            return out.peek();
        }

        private void move() {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        queue.enqueue(42);
        System.out.println(queue.dequeue()); // 42
        queue.enqueue(14);
        System.out.println(queue.peek());  // 14
        queue.enqueue(28);
        System.out.println(queue.peek());  // 14
        queue.enqueue(60);
        queue.enqueue(78);
        System.out.println(queue.dequeue());  // 14
        System.out.println(queue.dequeue());  // 28
    }
}
