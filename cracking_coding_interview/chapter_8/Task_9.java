package chapter_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Parens
 *
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 *
 */
public class Task_9 {

    public static void main(String[] args) {
        System.out.println(parentheses(3));
        System.out.println(generateParens(3));
    }

    public static Set<String> parentheses(int n) {
        if (n == 1) return new HashSet<>(Collections.singletonList("()"));

        Set<String> allPairs = new HashSet<>();

        for (String pair : parentheses(n - 1)) {
            allPairs.add("(" + pair + ")");
            allPairs.add("()" + pair);
            allPairs.add(pair + "()");
        }

        return allPairs;
    }

    static void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int index) {
       if (leftRem < 0 || rightRem < leftRem) return;

       if (leftRem == 0 && rightRem == 0) {
           list.add(String.copyValueOf(str));
       } else {
           str[index] = '(';
           addParent(list, leftRem - 1, rightRem, str, index + 1);

           str[index] = ')';
           addParent(list, leftRem, rightRem - 1, str, index + 1);
       }
    }

    public static ArrayList<String> generateParens(int count) {
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParent(list, count, count, str, 0);

        return list;
    }
}
