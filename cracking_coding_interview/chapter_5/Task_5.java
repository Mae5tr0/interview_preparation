package chapter_5;

/**
 * Debugger
 *
 * Explain what the following code does: ((n & (n-1)) == 0)
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        int n = 0B111000110101;
        System.out.println(((n & (n-1)) == 0)); // power 2
    }
}
