package chapter_1;

/**
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 */
public class Task_3 {
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith"));
        System.out.println(URLify(""));
        System.out.println(URLify(" "));
        System.out.println(URLify("AABB"));
    }

    private static String URLify(String input) {
        StringBuilder result = new StringBuilder();
        char[] inputCharArray = input.toCharArray();

        for (char c : inputCharArray) {
            if (c == ' ') {
                result.append("%20");
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
