package chapter_8;

/**
 * Recursive Multiply
 *
 * Write a recursive function to multiply two positive integers without using the * operator.
 * You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 *
 */
public class Task_5 {

    public static void main(String[] args) {
        System.out.println(3);
        System.out.println(5);

        System.out.println(multiply(3, 5));
        System.out.println(multiply2(3, 5));
    }

    // Naive approach: O(a)
    private static int multiply(int a, int b) {
        if (a == 1) return b;

        return b + multiply(a - 1, b);
    }

    // O(log(n))
    private static int multiply2(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;

        return multiplyHelper(smaller, bigger);
    }

    private static int multiplyHelper(int smaller, int bigger) {
        if (smaller == 0) return 0;
        if (smaller == 1) return bigger;

        int s = smaller >> 1; // Divide by 2
        int halfProduct = multiplyHelper(s, bigger);

        if (smaller % 2 == 0) {
            return halfProduct + halfProduct;
        } else {
            return halfProduct + halfProduct + bigger;
        }
    }
}