package chapter_1;

/**
 * Palindrome Permutation
 *
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 *
 */
public class Task_4 {
    public static void main(String[] args) {
        System.out.println(isPalindromPermutation("Tact Coa"));
    }

    // Complexity: n + n -> O(n)
    // Space: 2n + const -> O(n)
    private static boolean isPalindromPermutation(String input) {
        int[] charsStats = new int[128];
        int lettersCount = 0;

        char[] charsInput = input.toLowerCase().toCharArray();
        for (char letter : charsInput) {
            if (letter != ' ') {
                lettersCount++;
                charsStats[letter]++;
            }
        }

        if (isEven(lettersCount)) {
            for (int letterCount : charsStats) {
                if (!isEven(letterCount)) return false;
            }
        } else {
            boolean center = false;
            for (int letterCount : charsStats) {
                if (!isEven(letterCount) && center) return false;
                if (!isEven(letterCount)) center = true;
            }
        }

        return true;
    }


    private static boolean isEven(int number) {
        return (number % 2) == 0;
    }
}
