package problems;

/**
 * Good tuples
 *
 * Good tuple is only two from 3 numbers is the same.
 * Count good tuples in array
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 4, 8, 0}; // 2

        System.out.println(goodTuples(numbers));
    }

    static int goodTuples(int[] a) {
        int result = 0;
        for (int i = 0; i < a.length - 2; i++) {
            if ((a[i] == a[i + 1]) && (a[i] != a[i +2])) {
                result++;
            }
            if ((a[i] == a[i + 2]) && (a[i] != a[i +1])) {
                result++;
            }
            if ((a[i + 1] == a[i + 2]) && (a[i + 1] != a[i])) {
                result++;
            }
        }

        return result;
    }
}
