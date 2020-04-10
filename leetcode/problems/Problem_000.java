package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *  ()[]
 *
 */
public class Problem_000 {
    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        for (List<String> group : groupAnagrams(arr)) {
            System.out.println(Arrays.toString(group.toArray()));
        }
    }

    // Anagram when sorted letter is the same
    public static List<List<String>> groupAnagrams(String[] strs) {
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
    // will be more optimal
}
