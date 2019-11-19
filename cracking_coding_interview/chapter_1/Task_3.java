package chapter_1;

/**
 * URLify
 *
 * Write a method to replace all spaces in a string with '%20'.
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 *
 */
public class Task_3 {
    public static void main(String[] args) {
        System.out.println(URLify("Mr John Smith"));
        System.out.println(URLify(""));
        System.out.println(URLify(" "));
        System.out.println(URLify("AABB"));

        System.out.println(URLify_2("Mr John Smith"));
    }

    // Complexity: n + n -> O(n)
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

    // Using only character array
    // Complexity: n + n -> O(n)
    private static String URLify_2(String input) {
        int spaceCount = 0;

        // calc total spaces
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') spaceCount++;
        }

        char[] inputCharArray = new char[input.length() - spaceCount + spaceCount * 3];
        int charArrayPointer = inputCharArray.length - 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            if (letter == ' ') {
                inputCharArray[charArrayPointer] = '0';
                inputCharArray[charArrayPointer - 1] = '2';
                inputCharArray[charArrayPointer - 2] = '%';
                charArrayPointer -= 3;
            } else {
                inputCharArray[charArrayPointer] = letter;
                charArrayPointer--;
            }
        }

        return new String(inputCharArray);
    }

}
