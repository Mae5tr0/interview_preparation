package chapter_16;

/**
 * Number Swapper
 *
 * Write a function to swap a number in place (that is, without temporary vari­ ables).
 *
 */
public class Task_1 {

    public static void main(String[] args) {
        int a = 17;
        int b = 3;

        System.out.println(a + " -> " + Integer.toBinaryString(a));
        System.out.println(b + " -> " + Integer.toBinaryString(b));

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " -> " + Integer.toBinaryString(a));
        System.out.println(b + " -> " + Integer.toBinaryString(b));

        // diff
        a = 5;
        b = 9;

        System.out.println(a);
        System.out.println(b);

        a = b - a; // diff
        b = b - a; // a
        a = a + b; // b

        System.out.println(a);
        System.out.println(b);
    }
}