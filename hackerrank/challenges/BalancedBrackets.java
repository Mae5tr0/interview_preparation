package challenges;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
       System.out.println(isBalanced("{[()]}"));
       System.out.println(isBalanced("{[(])}"));
       System.out.println(isBalanced("{{[[(())]]}}"));
    }

    static String isBalanced(String input) {
        Stack<Character> brackets = new Stack<>();

        for (Character c : input.toCharArray()) {
            if (c.equals('{') || c.equals('[') || c.equals('(')) brackets.push(c);
            else {
                if (brackets.isEmpty()) return "NO";
                if (!isMatched(brackets.pop(), c)) return "NO";
            }
        }
        if (!brackets.isEmpty()) return "NO";

        return "YES";
    }

    static boolean isMatched(Character open, Character closed) {
        if (open.equals('{') && closed.equals('}')) return true;
        if (open.equals('(') && closed.equals(')')) return true;
        if (open.equals('[') && closed.equals(']')) return true;

        return false;
    }
}
