package challenges;

import java.util.HashSet;

public class TwoStrings {
    public static void main(String[] args) {
        System.out.println(twoStrings("hello", "world")); // YES
        System.out.println(twoStrings("hi", "world")); // NO
    }

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        HashSet<Character> letters = new HashSet<>();
        for (char c : s1.toCharArray()) {
            letters.add(c);
        }

        for (char c : s2.toCharArray()) {
            if (letters.contains(c)) return "YES";
        }

        return "NO";
    }
}
