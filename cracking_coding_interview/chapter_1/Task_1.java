package chapter_1;

import java.util.Arrays;

/**
 * Is Unique
 *
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Task_1 {
    public static void main(String[] args) {
        System.out.println(isUnique("test"));
        System.out.println(isUnique("adfb"));
        System.out.println(isUnique("aaa"));
        System.out.println(isUnique(""));
    }

    // without using additional data structures,
    // if we assumed, that charArray is the representation string itself
    // Complexity: n * log n + n -> O(n * log n)
    private static boolean isUnique(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) return false;
        }

        return true;
    }

    // Using additional data structures
    // Assume, that encoding is ASCII (256 bit)
    // Complexity: O(n), but in fact -> O(1), because invariant limited to alphabet
    // Space: O(1)
    private static boolean isUnique_2(String input) {
        // is alphabet is 256, so maximum unique characters is only 128;
        if (input.length() > 128) return false;

        boolean[] chars = new boolean[256];

        for (int i = 0; i < input.length(); i++) {
            char letter = input.charAt(i);

            if (chars[letter]) return false;
            chars[letter] = true;
        }

        return true;
    }

    // Using bit vector
    // Assuming, than string uses only 'a'-'z'
    private static boolean isUnique_3(String input) {
        int checker = 0;

        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }

            checker |= (1 << val);
        }

        return true;
    }

    // Other approaches:
    // Compare each characters with other -> O(n^2), Space O(1)
}
