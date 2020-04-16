package problems;

import java.util.Stack;

/**
 * (Backspace String Compare)[https://leetcode.com/problems/backspace-string-compare/]
 */
public class Problem_844 {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c")); // true
        System.out.println(backspaceCompare("ab##", "c#d#")); // true
        System.out.println(backspaceCompare("a##c", "#a#c")); // true
        System.out.println(backspaceCompare("a#c", "b")); // false
    }

    // stack based
    public static boolean backspaceCompare(String S, String T) {
        return processBackspaces(S).equals(processBackspaces(T));
    }

    public static String processBackspaces(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.toString();
    }
}