package chapter_8;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Stack of Boxes
 *
 * You have a stack of n boxes, with widths wi, heights hi, and depths di. The boxes cannot be rotated and can only
 * be stacked on top of one another if each box in the stack is strictly larger than the box above it in width,
 * height, and depth. Implement a method to compute the height of the tallest possible stack.
 * The height of a stack is the sum of the heights of each box.
 *
 */
public class Task_13 {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(new Box(10, 12, 15));
        boxes.add(new Box(8, 12, 15));
        boxes.add(new Box(12, 11, 15));
        boxes.add(new Box(4, 11, 14));
        boxes.add(new Box(5, 12, 15));

        System.out.println(createStack(boxes));
    }

    private static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes);
        int maxHeight = 0;
        int[] stackMap = new int[boxes.size()];
        for (int i = 0; i < boxes.size(); i++) {
            maxHeight = Math.max(maxHeight, createStack(boxes, i, stackMap));
        }

        return maxHeight;
    }

    private static int createStack(ArrayList<Box> boxes, int bottomIndex, int[] stackMap) {
        if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) {
            return stackMap[bottomIndex];
        }

        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex + 1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                maxHeight = Math.max(maxHeight, createStack(boxes, i, stackMap));
            }
        }
        maxHeight += bottom.height;
        stackMap[bottomIndex] = maxHeight;

        return maxHeight;
    }

    static class Box implements Comparable<Box> {
        private int height;
        private int weight;
        private int depth;

        public Box(int height, int weight, int depth) {
            this.height = height;
            this.weight = weight;
            this.depth = depth;
        }

        public boolean canBeAbove(Box other) {
            return height < other.height && weight < other.weight && depth < other.depth;
        }

        @Override
        public int compareTo(Box o) {
            return o.height - height;
        }

        @Override
        public String toString() {
            return "Box{" +
                    "" + height +
                    ", " + weight +
                    ", " + depth +
                    '}';
        }
    }
}
