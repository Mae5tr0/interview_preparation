package chapter_3;

import java.util.Arrays;

/**
 * Three in One
 *
 * Describe how you could use a single array to implement three stacks.
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        ThreeStacks<Integer> stacks = new ThreeStacks(3, 6);

        stacks.push(1, 1);
        stacks.push(1, 1);
        stacks.push(2, 2);
        stacks.push(2, 2);
        stacks.push(3, 3);
        stacks.push(3, 3);

        System.out.println(stacks);

        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));

        System.out.println(stacks);

        System.out.println(stacks.pop(2));
        System.out.println(stacks);

        stacks.push(1, 10);
        System.out.println(stacks);
    }

    // Complexity: O(a), Memory: O(n + a); a - arrays count; n - total size
    private static class ThreeStacks<E> {
        int[] positions;
        E[] elements;

        public ThreeStacks(int arraysCount, int totalSize) {
            if (arraysCount < 1 || arraysCount > totalSize)
                throw new IllegalArgumentException("Invalid initial params");

            elements = (E[]) new Object[totalSize];
            positions = new int[arraysCount];
            for (int i = 0; i < arraysCount; i++) {
                positions[i] = i * totalSize / arraysCount;
            }
        }

        public void push(int number, E value) {
            validateNumber(number);
            int positionIndex = number - 1;

            if (positions[positionIndex] >= number * (elements.length / positions.length))
                throw new IndexOutOfBoundsException("Array size exhausted");

            elements[positions[positionIndex]] = value;
            positions[positionIndex]++;
        }

        public E pop(int number) {
            validateNumber(number);
            int positionIndex = number - 1;

            if (positions[positionIndex] == 0)
                throw new IndexOutOfBoundsException("Empty stack");

            positions[positionIndex]--;
            E result = elements[positions[positionIndex]];
            elements[positions[positionIndex]] = null;

            return result;
        }

        private void validateNumber(int number) {
            if (number < 1 || number > positions.length)
                throw new IllegalArgumentException("Invalid number, must be from " + 1 + " to " + positions.length);
        }

        @Override
        public String toString() {
            return "ThreeStacks{" +
                    "positions=" + Arrays.toString(positions) +
                    ", elements=" + Arrays.toString(elements) +
                    '}';
        }
    }
}
