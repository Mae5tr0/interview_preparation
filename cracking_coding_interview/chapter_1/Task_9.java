package chapter_1;

/**
 * String Rotation
 *
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, sl and s2, write code to check if s2 is a rotation of s1 using only one call
 * to isSubstring (e.g.,"waterbottle" is a rotation of"erbottlewat").
 *
 */
public class Task_9 {
    public static void main(String[] args) {
        System.out.println(isRotatedString("waterbottle", "erbottlewat"));
    }

    // Complexity: building a string + searching substring -> depends from function isSubstring
    private static boolean isRotatedString(String input, String example) {
        return isSubstring(input + input, example);
    }

    // don't care about complexity
    private static boolean isSubstring(String input, String example) {
        return input.indexOf(example) > 0;
    }
}



