package chapter_2;

import structures.LinkedList;
import java.util.Arrays;

/**
 * Palindrome
 *
 * Implement a function to check if a linked list is a palindrome.
 *
 */
public class Task_6 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(new LinkedList<>(Arrays.asList("A", "B", "C", "C", "B", "A")))); //true
        System.out.println(isPalindrome(new LinkedList<>(Arrays.asList("A", "B", "C", "B", "A")))); //true

        System.out.println(isPalindrome(new LinkedList<>(Arrays.asList("A", "B", "C", "A")))); //false
        System.out.println(isPalindrome(new LinkedList<>(Arrays.asList("A", "B", "C", "C", "A")))); //false
    }

    // Complexity: n/2 -> O(n), Memory: O(1)
    private static boolean isPalindrome(LinkedList<String> input) {
        LinkedList.Node start = input.getNode(0);
        LinkedList.Node end = input.getNode(input.length() - 1);

        for (int i = 0; i < input.length()/2 ; i++) {
            if (start.item != end.item) return false;
            start = start.next;
            end = end.prev;
        }

        return true;
    }
}
