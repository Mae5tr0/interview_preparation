package problems;

/**
 * (Count and Say)[https://leetcode.com/problems/count-and-say/]
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 *  1. 1
 *  2. 11
 *  3. 21
 *  4. 1211
 *  5. 111221
 *
 */
public class Problem_38 {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
    }

    static public String countAndSay(int n) {
        String result = "1";
        for (int i = n - 1; i > 0; i--) {
            result = generateCountAndSay(result);
        }

        return result;
    }

    static public String generateCountAndSay(String input) {
        if (input.length() == 1) return "1" + input;

        StringBuilder result = new StringBuilder();
        char[] digits = input.toCharArray();
        int counter = 1;
        char current = digits[0];
        for (int i = 1; i < digits.length - 1; i++) {
            if (digits[i] == current) {
                counter++;
            } else {
                result.append(counter).append(current);
                counter = 1;
                current = digits[i];
            }
        }
        char lastDigit = digits[digits.length - 1];
        if (lastDigit == current) {
            result.append(counter + 1).append(lastDigit);
        } else {
            result.append(counter).append(current).append(1).append(lastDigit);
        }

        return result.toString();
    }

}
