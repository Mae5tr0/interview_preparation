package chapter_1;

/**
 * One Away
 *
 * There are three types of edits that can be performed on strings: insert a character, remove a character,
 * or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        // true
        System.out.println(isOneEdit("bake", "sbake"));
        System.out.println(isOneEdit("bake", "baske"));
        System.out.println(isOneEdit("bake", "bak"));

        // false
        System.out.println(isOneEdit("bake", "bask"));
        System.out.println(isOneEdit("abc", "bca"));
        System.out.println(isOneEdit("aaab", "aa"));
    }

    // Complexity: O(n), n - length of the shorter string
    public static boolean isOneEdit(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1) return false;

        if (a.length() == b.length()) {
            return oneEditReplace(a, b);
        } else if (a.length() + 1 == b.length()) {
            return oneEditInsert(a, b);
        } else if (a.length() == b.length() + 1) {
            return oneEditInsert(b, a);
        }

        return false;
    }

    private static boolean oneEditReplace(String a, String b) {
        boolean foundDifference = false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (foundDifference) return false;
                foundDifference = true;
            }
        }

        return true;
    }

    // a > b; a - b < 1
    private static boolean oneEditInsert(String a, String b) {
        int aPosition = 0;
        int bPosition = 0;
        while (aPosition < a.length() && bPosition < b.length()) {
            if (a.charAt(aPosition) != b.charAt(bPosition)) {
                if (aPosition != bPosition) return false;
                aPosition++;
            } else {
                aPosition++;
                bPosition++;
            }
        }

        return true;
    }
}



