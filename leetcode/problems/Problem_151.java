package problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an input string, reverse the string word by word.
 */
public class Problem_151 {
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue")); //blue is sky the
        System.out.println(reverseWords("  hello world!  ")); //world! hello
        System.out.println(reverseWords("a good   example")); //example good a
    }

    public static String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
