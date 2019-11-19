package chapter_1;

import java.util.Arrays;

/**
 * Check Permutation
 *
 * Given two strings, write a method to decide if one is a permutation of the other
 *
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abc", "bcaa"));
        System.out.println(checkPermutation("", ""));
        System.out.println(checkPermutation("fasdfasdfasdf", "kj;ljkljkl;"));
    }

    // Complexity is a * log a + b log b + a, but a == b, so O (n * log n)
    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        return sort(a).equals(sort(b));
    }

    private static String sort(String s) {
        char[] aChars = s.toCharArray();
        Arrays.sort(aChars);
        return new String(aChars);
    }


    private static boolean checkPermutation_2(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] charsCount = new int[128]; // Word can consist only from letters
        char[] aCharArray = a.toCharArray();
        for (char c : aCharArray) {
            charsCount[c]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int letter = b.charAt(i);

            charsCount[letter]--;
            if (charsCount[letter] < 0) return false;
        }

        return true;
    }
}
