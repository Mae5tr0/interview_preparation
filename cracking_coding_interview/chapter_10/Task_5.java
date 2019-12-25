package chapter_10;

/**
 * Sparse Search
 *
 * Given a sorted array of strings that is interspersed with empty strings,
 * write a method to find the location of a given string.
 *
 */
public class Task_5 {
    public static void main(String[] args) {
        String[] input = {"at", "", "", "", "ball", "", "", "", "car", "", "", "dad", "", ""};

        System.out.println(search("ball", input, 0, input.length - 1)); // 4
    }

    public static int search(String searchedWord, String[] words, int low, int high) {
        int mid;

        while (low <= high) {
            mid = middle(words, low, high);

            if (mid == -1) return -1;

            String word = words[mid];
            if (searchedWord.compareTo(word) < 0) {
                high = mid - 1;
            } else if (searchedWord.compareTo(word) > 0) {
                low = mid + 1;
            } else return mid;
        }

        return -1;
    }

    static public int middle(String[] words, int low, int high) {
        int middle = (low + high) / 2;

        if (!words[middle].isEmpty()) return middle;
        int left = middle - 1;
        int right = middle + 1;

        while (true) {
            if (left < low && right > high) {
                return -1;
            } else if (right <= high && !words[right].isEmpty()) {
                return right;
            } else if (left >= low && !words[low].isEmpty()) {
                return low;
            }
            right++;
            left--;
        }
    }
}