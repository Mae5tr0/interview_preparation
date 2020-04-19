package problems;

/**
 * (Valid Parenthesis String)[https://leetcode.com/problems/valid-parenthesis-string/]
 */
public class Problem_678 {
    public static void main(String[] args) {
        System.out.println(checkValidString("()"));   // true
        System.out.println(checkValidString("*"));    // true
        System.out.println(checkValidString("*)"));   // true
        System.out.println(checkValidString("(*)"));  // true
        System.out.println(checkValidString("(**"));  // true
        System.out.println(checkValidString("(*"));   // true
        System.out.println(checkValidString("()*"));  // true
        System.out.println(checkValidString("()*)")); // true
        System.out.println(checkValidString("((**")); // true
        System.out.println(checkValidString("**))")); // true
        System.out.println(checkValidString("((*"));  // false

        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));  // false
    }

    public static boolean checkValidString(String s) {
        int cmin = 0, cmax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cmax++;
                cmin++;
            } else if (c == ')') {
                cmax--;
                cmin--;
            } else if (c == '*') {
                cmax++;
                cmin--;
            }
            if (cmax < 0) return false;
            cmin = Math.max(cmin, 0);
        }
        return cmin == 0;
    }
}