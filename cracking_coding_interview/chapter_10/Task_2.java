package chapter_10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Group Anagrams
 *
 * Write a method to sort an array ot strings so that all tne anagrams are next to each other.
 *
 */
public class Task_2 {

    public static void main(String[] args) {
        String[] words = {"backer", "acre", "bitbox", "care", "race"};

        HashMap<String, LinkedList<String>> mapList = new HashMap<>();

        for (String word : words) {
            String key = sortChars(word);
            LinkedList<String> values = mapList.get(key);
            if (values == null) values = new LinkedList<>();
            values.add(word);
            mapList.put(key, values);
        }

        int index = 0;
        for (String key : mapList.keySet()) {
            for (String word : mapList.get(key)) {
                words[index] = word;
                index++;
            }
        }

        System.out.println(Arrays.toString(words));
    }


    private static String sortChars(String s) {
        char[] sortedChars = s.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}