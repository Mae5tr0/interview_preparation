package problems;

import java.util.Arrays;

/**
 * (Increasing Decreasing String)[https://leetcode.com/problems/increasing-decreasing-string/]
 */
public class Problem_1370 {
    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc")); // abccbaabccba
        System.out.println(sortString("rat")); // art
        System.out.println(sortString("leetcode")); // cdelotee
        System.out.println(sortString("ggggggg")); // ggggggg
        System.out.println(sortString("spo")); // ops
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
}
