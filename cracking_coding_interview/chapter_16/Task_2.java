package chapter_16;

/**
 * Word Frequencies
 *
 * Design a method to find the frequency of occurrences of any given word in a book.
 * What if we were running this algorithm multiple times?
 *
 */
public class Task_2 {
    public static int frequency(String[] book, String word) {
        word = word.trim().toLowerCase();
        int count = 0;
        for (String w : book) {
            if (w.trim().toLowerCase().equals(word)) {
                count++;
            }
        }

        return count;
    }
}
