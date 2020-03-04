package contests;

import java.util.Arrays;
import java.util.HashMap;

public class Biweekly_21 {
//    public static void main(String[] args) {
//        System.out.println(sortString("aaaabbbbcccc")); // abccbaabccba
//        System.out.println(sortString("rat")); // art
//        System.out.println(sortString("leetcode")); // cdelotee
//        System.out.println(sortString("ggggggg")); // ggggggg
//        System.out.println(sortString("spo")); // ops
//    }

    public static void main(String[] args) {

    }

    static public String sortString(String s) {
        char[] input = s.toCharArray();
        Arrays.sort(input);

        StringBuilder result = new StringBuilder();

        while (result.length() != input.length) {
            char prev = '\n';
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] == '\n') continue;
                if (input[i] == prev) continue;
                result.append(input[i]);
                prev = input[i];
                input[i] = '\n';
            }

            prev = '\n';
            for (int i = input.length - 1; i >= 0; i--) {
                if (input[i] == '\n') continue;
                if (prev == input[i]) continue;
                result.append(input[i]);
                prev = input[i];
                input[i] = '\n';
            }
        }

        return result.toString();
    }

    static public int findTheLongestSubstring(String s) {
        return findTheLongestSubstring(s.toCharArray(), 0 , s.length() - 1);
    }

    static public int findTheLongestSubstring(char[] input, int min, int max) {
        if (max == min) return 0;

        int mid = (min + max)/2;

        return Math.max(Math.max(
                findTheLongestSubstring(input, min, mid),
                findTheLongestSubstring(input, mid + 1, max)),
                findTheLongestSubstringCrossing(input, min, mid, max)
        );
    }

    static public int findTheLongestSubstringCrossing(char[] input, int min, int mid, int max) {
        HashMap<Character, Integer> vowels = new HashMap<>();
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('a', 0);
        vowels.put('u', 0);

        int maxSubstring = 1;
        Character key = input[mid];
        Integer value = vowels.get(input[mid]);
        if (value != null) {
            vowels.put(key, value + 1);
        }
        boolean step = true;
        int leftChar = mid;
        int rightChar = mid + 1;
        while (step) {
            step = false;

            if (leftChar > 0) {
                leftChar--;
                Character c = input[leftChar];
                if (vowels.get(c) == null) {
                    maxSubstring++;
                } else {

                }

            }




        }

        return maxSubstring;
    }
}
