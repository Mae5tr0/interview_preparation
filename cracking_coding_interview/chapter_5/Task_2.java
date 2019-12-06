package chapter_5;

/**
 * Binary to String
 *
 * Given a real number between O and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
 * If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR:'
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println(binaryRepresentation(0.625)); // .101
    }

    public static String binaryRepresentation(double n) {
        StringBuilder result = new StringBuilder();
        result.append('.');

        while (n > 0) {
            if (result.length() >= 32) return "ERROR";

            double next = n * 2;
            if (next >= 1) {
                result.append(1);
                n = next - 1;
            } else {
                result.append(0);
                n = next;
            }
        }

        return result.toString();
    }
}
