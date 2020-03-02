package chapter_16;

/**
 * Factorial Zero
 *
 * Write an algorithm which computes the number of trailing zeros in n factorial
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        System.out.println(zeros(17));
    }

    public static int zeros(int num) {
        int count = 0;

        for (int i = 5; num/i > 0; i *= 5) {
            count += num /i;
        }
        return  count;
    }
}
