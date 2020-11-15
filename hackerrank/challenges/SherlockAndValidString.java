package challenges;

import java.util.Arrays;

public class SherlockAndValidString {
    static String isValid(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }

        String result = "NO";
        Arrays.sort(charFreq);
        int i = 0;
        while (charFreq[i] == 0) {
            i++;
        }
        int min = charFreq[i];
        int max = charFreq[25];
        if (min == max) return "YES";
        else {
            if (((max - min == 1) && (max > charFreq[24])) || (min == 1) && (charFreq[i + 1] == max)) return "YES";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbcd")); // NO
        System.out.println(isValid("aabbccddeefghi")); // NO
        System.out.println(isValid("abcdefghhgfedecba")); // YES
    }
}
