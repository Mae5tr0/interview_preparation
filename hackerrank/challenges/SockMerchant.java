package challenges;

import java.util.HashMap;

public class SockMerchant {
    public static void main(String[] args) {
        System.out.println(sockMerchant(9 , new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20})); // 3
    }

    static int sockMerchant(int n, int[] ar) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        int pairs = 0;
        for (int v : ar) {
            int newVal = freq.getOrDefault(v, 0) + 1;
            freq.put(v, newVal );
        }
        for (Integer key : freq.keySet()) {
            pairs += freq.get(key) / 2;
        }

        return pairs;
    }
}
