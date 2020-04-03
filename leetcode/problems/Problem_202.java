package problems;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until
 * the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 */
public class Problem_202 {
    public static void main(String[] args) {
        System.out.println(isHappy(19)); // true
    }

    static public boolean isHappy(int n) {
       HashSet<Integer> previous = new HashSet<Integer>();

       while (n != 1) {
           if (previous.contains(n)) return false;

           previous.add(n);

           int sum = 0;
           while (n / 10 >= 1) {
               int digit = n % 10;
               sum += digit * digit;
               n = n / 10;
           }
           sum += n * n;
           n = sum;
       }

       return true;
    }

}
