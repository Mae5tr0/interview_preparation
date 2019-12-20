package chapter_8;

import structures.HashMap;

/**
 * Boolean Evaluation
 *
 * Given a boolean expression consisting of the symbols 0 (false), 1 (true), & (AND), I (OR), and /\ (XOR),
 * and a desired boolean result value result, implement a function to count the number of ways of parenthesizing
 * the expression such that it evaluates to result.
 * The expression should be fully parenthesized (e.g.,(0)A(1)) but not extraneously (e.g.,(((0))/\(1)))
 *
 */
public class Task_14 {
    public static void main(String[] args) {
        HashMap<String, Integer> memo = new HashMap<>();

        System.out.println(countEval("1^0|0|1", false, memo)); // 2
        System.out.println(countEval("0&0&0&1^1|0", true, memo)); // 10
    }

    private static int countEval(String expression, boolean expected, HashMap<String, Integer> memo) {
        if (expression.length() == 0) return 0;
        if (expression.length() == 1) return stringToBool(expression) == expected ? 1 : 0;
        if (memo.contains(expected + expression)) return memo.get(expected + expression);

        int ways = 0;
        for (int i = 1; i < expression.length(); i += 2) {
            char c = expression.charAt(i);
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1);

            int leftTrue = countEval(left, true, memo);
            int leftFalse = countEval(left, false, memo);
            int rightTrue = countEval(right, true, memo);
            int rightFalse = countEval(right, false, memo);
            int total = (leftTrue + leftFalse) * (rightTrue + rightFalse);

            int totalTrue = 0;
            if (c == '^') {
                totalTrue = leftTrue * rightFalse + leftFalse * rightTrue;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue = leftTrue * rightTrue + leftFalse * rightTrue + leftTrue * rightFalse;
            }

            int subways = expected ? totalTrue : total - totalTrue;
            ways += subways;
        }

        memo.put(expected + expression, ways);
        return ways;
    }

    static boolean stringToBool (String c) {
        return c.equals("1");
    }
}
