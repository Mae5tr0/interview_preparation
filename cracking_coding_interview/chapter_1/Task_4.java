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
//        System.out.println(isPalindromPermutation("Tact Coa"));
        System.out.println(isPalindromPermutation2("Tact Coa")); // true
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

    private static boolean isPalindromPermutation2(String input) {
        int bitVector = createBitVector(input);
        return bitVector == 0 || checkOnlyOneBitSet(bitVector);
    }

    private static int createBitVector(String input) {
        int result = 0;
        for (char c : input.toLowerCase().toCharArray()) {
            int position = getCharNumber(c);
            result = toggle(result, position);
        }

        return result;
    }

    private static int toggle(int bitVector, int index) {
        if (index < 0 || index > 26) return bitVector;
        int mask = 1 << index;

        if ((bitVector & mask) == 0) {
            bitVector |= mask;
        } else {
            bitVector &= ~mask;
        }

        return bitVector;
    }

    private static boolean checkOnlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    private static int getCharNumber(char c) {
        return c - 'a';
    }

}
