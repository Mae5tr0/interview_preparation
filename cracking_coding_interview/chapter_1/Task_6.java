package chapter_1;

/**
 * String Compression
 *
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class Task_6 {
    public static void main(String[] args) {
        System.out.println(compess("aabcccccaaa")); //a2blc5a3
        System.out.println(compess("abcdefg"));
        System.out.println(compess("aa"));
        System.out.println(compess("abcdefghhhhhhhhhhh"));
    }

    // Complexity: O(n), Memory: 2n + const -> O(n)
    private static String compess(String input) {
        if (input.length() < 3) return input;

        char currentLetter = input.charAt(0);
        int count = 1;

        // if we added additional loop and calc final length, we can skip building a string,
        // if this length will be more than original, and second we can create StringBuilder with final length
        // and skip it's doubling size in process
        StringBuilder buffer = new StringBuilder();
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != currentLetter) {
                buffer.append(currentLetter).append(count);
                count = 1;
                currentLetter = input.charAt(i);
            } else {
                count++;
            }
        }
        buffer.append(currentLetter).append(count);

        String result = buffer.toString();

        return result.length() < input.length() ? result : input;
    }
}



