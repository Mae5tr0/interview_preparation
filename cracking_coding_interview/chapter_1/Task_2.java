package chapter_1;

import java.util.Arrays;

/**
 * Given two strings,write a method to decide if one is a permutation of the other
 */
public class Task_2 {
    public static void main(String[] args) {
        System.out.println(checkPermutation("abc", "bca"));
        System.out.println(checkPermutation("abc", "bcaa"));
        System.out.println(checkPermutation("", ""));
        System.out.println(checkPermutation("fasdfasdfasdf", "kj;ljkljkl;"));
    }

    private static boolean checkPermutation(String a, String b) {
        if (a.length() != b.length()) return false;

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);

        for (int i = 0; i < a.length(); i++) {
            if (aChars[i] != bChars[i]) return false;
        }

        return true;
    }
}
