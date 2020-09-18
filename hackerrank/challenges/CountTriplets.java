package challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CountTriplets {
    public static void main(String[] args) {
        System.out.println(countTriplets(toLongList(new int[]{1, 2, 2, 4}), 2)); // 2
        System.out.println(countTriplets(toLongList(new int[]{1, 4, 16, 64}), 4)); // 2
        System.out.println(countTriplets(toLongList(new int[]{1, 3, 9, 9, 27, 81}), 3)); // 6
        System.out.println(countTriplets(toLongList(new int[]{1, 5, 5, 25, 125}), 5)); // 4
        System.out.println(countTriplets(toLongList(new int[]{1, 5, 5, 5}), 5)); // 0
    }

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> freq = new HashMap<>();
        HashMap<Long, Long> pairs = new HashMap<>();
        long triplets = 0;

        for (int i = arr.size() - 1; i >= 0; i--) {
            if (pairs.get(arr.get(i) * r) != null) {
                triplets += pairs.get(arr.get(i) * r);
            }
            if (freq.get(arr.get(i) * r) != null) {
                pairs.put(arr.get(i), pairs.getOrDefault(arr.get(i), (long) 0) + freq.get(arr.get(i) * r));
            }
            freq.put(arr.get(i), freq.getOrDefault(arr.get(i), (long) 0) + 1);
        }

        return triplets;
    }

    static List<Long> toLongList(int[] arr) {
        List<Long> result = new LinkedList<>();

        for (int a : arr) {
            result.add((long) a);
        }

        return result;
    }
}
