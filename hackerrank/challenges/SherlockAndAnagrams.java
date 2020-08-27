package challenges;

import java.util.Arrays;
import java.util.HashMap;

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba")); // 4
        System.out.println(sherlockAndAnagrams("abcd")); // 0
        System.out.println(sherlockAndAnagrams("ifailuhkqq")); // 3
        System.out.println(sherlockAndAnagrams("kkkk")); // 10
        System.out.println(sherlockAndAnagrams("cdcd")); // 5
    }

    // Brutforce
    static int sherlockAndAnagrams(String s) {
        char[] letters = s.toCharArray();

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j <= i; j++) {
                putString(map, new String(letters, j, i - j + 1));
            }
        }

        int count = 0;
        for (Integer freq : map.values()) {
            count += freq * (freq - 1)/2;
        }

        return count;
    }

    static void putString(HashMap<String, Integer> map, String key) {
        char[] keyCharArray = key.toCharArray();
        Arrays.sort(keyCharArray);
        key = new String(keyCharArray);

        Integer value = map.getOrDefault(key, 0);
        map.put(key, value + 1);
    }
}
