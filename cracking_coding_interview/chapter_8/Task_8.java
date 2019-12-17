package chapter_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Permutations with Duplicates
 *
 * Write a method to compute all permutations of a string whose characters are not necessarily unique.
 * The list of permutations should not have duplicates.
 *
 */
public class Task_8 {

    public static void main(String[] args) {
        System.out.println(permutations("abad"));
    }

    private static List<String> permutations(String input) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<Character, Integer> map = buildFreqMap(input);
        allPermutations(map, "", input.length(), result);

        return result;
    }

    private static HashMap<Character, Integer> buildFreqMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        return map;
    }

    private static void allPermutations(HashMap<Character, Integer> map, String prefix,
                                                       int remaining, ArrayList<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            int count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                allPermutations(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }
        }
    }
}
