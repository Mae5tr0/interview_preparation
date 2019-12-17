package chapter_8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Permutations without Dups
 *
 * Write a method to compute all permutations of a string of unique characters.
 *
 */
public class Task_7 {

    public static void main(String[] args) {
        System.out.println(permutations("abcd"));
    }

    private static List<String> permutations(String input) {
        return allPermutations(new StringBuilder(input))
                .stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());
    }

    private static List<StringBuilder> allPermutations(StringBuilder input) {
        LinkedList<StringBuilder> permutations = new LinkedList<>();

        if (input.length() == 1) {
            List<StringBuilder> list = new LinkedList<>();
            list.add(new StringBuilder(input));
            return list;
        }

        for (int i = 0; i < input.length(); i++) {
            for (StringBuilder permutation : allPermutations(new StringBuilder(input).deleteCharAt(i))) {
                permutation.insert(0, input.charAt(i));

                permutations.addLast(permutation);
            }
        }

        return permutations;
    }
}
