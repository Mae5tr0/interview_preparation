package chapter_17;

/**
 * Add Without Plus
 *
 * Write a function that adds two numbers. You should not use+ or any arithmetic operators.
 *
 */
public class Task_1 {

    public static void main(String[] args) {
        System.out.println(add(10, 11)); // 21
        System.out.println(add(3, 2)); // 5
        System.out.println(add(17, 133)); // 150
    }

    private static int add(int a, int b) {
        return a + b;
    }

    private static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    private static int setBit(int num, int i) {
        return num | (1 << i);
    }
}