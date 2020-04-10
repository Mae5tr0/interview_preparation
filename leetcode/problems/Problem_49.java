package problems;

import java.util.*;

/**
 *  (Group Anagrams)[https://leetcode.com/problems/group-anagrams/]
 *
 *  Given an array of strings, group anagrams together.
 *
 */
public class Problem_49 {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> group : groupAnagrams2(arr)) {
            System.out.println(Arrays.toString(group.toArray()));
        }
    }

    // Anagram when sorted letter is the same
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] cStr = str.toCharArray();
            Arrays.sort(cStr);
            String key = new String(cStr);

            if (!groups.containsKey(key)) groups.put(key, new LinkedList<>());

            groups.get(key).add(str);
        }

        return new LinkedList<>(groups.values());
    }

    // Anagram when letter count is the same
    // will be more optimal, because counting chars is linear, instead sorting, which
    // is (n * log n) in general. If we will use counting sort complexity will be the same
    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] counts = new int[26]; // English alphabet
            for (char c : str.toCharArray()) {
                counts[c]++;
            }
            String key = "";
            for (int charCount : counts) {
                key += ("#" + charCount);
            }

            if (!groups.containsKey(key)) groups.put(key, new LinkedList<>());

            groups.get(key).add(str);
        }

        return new LinkedList<>(groups.values());
    }

    // Another approach - using map structure as a key
//    private static Map<Character, Integer> createKey(String str) {
//        Map<Character, Integer> key = new HashMap();
//        for (int i = 0; i < str.length(); i++) {
//            char ch = str.charAt(i);
//            key.merge(ch, 1, Integer::sum);
//        }
//        return key;
//    }
}
