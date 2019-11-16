package chapter_1;

import java.util.Arrays;

/**
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
    private static boolean isUnique(String input) {
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) return false;
        }

        return true;
    }
}
