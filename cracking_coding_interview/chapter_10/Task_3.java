package chapter_10;

/**
 * Search in Rotated Array
 *
 * Given a sorted array of n integers that has been rotated an unknown number of times,
 * write code to find an element in the array.
 * You may assume that the array was originally sorted in increasing order.
 *
 */
public class Task_3 {

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        System.out.println(search(arr, 5, 0, arr.length - 1)); // 8
    }

    public static int search(int[] arr, int value, int low, int high) {
        int mid = (low + high) / 2;
        if (arr[mid] == value) return mid;
        if (low > high) return -1;

        if (arr[low] < arr[mid]) { // left normally ordered
            if (value < arr[mid] && value > arr[low]) {
                return search(arr, value, low, mid - 1);
            } else {
                return search(arr, value, mid + 1, mid - 1);
            }
        } else if (arr[mid] < arr[high]) { // right normally ordered
            if (value > arr[mid] && value < arr[high]) {
                return search(arr, value, mid + 1, high);
            } else {
                return search(arr, value, low, mid - 1);
            }
        } else if (arr[low] == arr[high]) {
            if (arr[mid] != arr[high]) {
                return search(arr, value, mid + 1, high);
            } else {
                int result = search(arr, value, low, mid - 1);
                if (result == -1) {
                    return search(arr, value, mid + 1, high);
                } else {
                    return result;
                }
            }
        }

        return -1;
    }

}