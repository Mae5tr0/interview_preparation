package problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * (Last Stone Weight)[https://leetcode.com/problems/last-stone-weight/]
 *
 * We have a collection of stones, each stone has a positive integer weight.
 *
 * Each turn, we choose the two heaviest stones and smash them together.
 * Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 * If x == y, both stones are totally destroyed;
 * If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 * At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 */
public class Problem_1046 {
    public static void main(String[] args) {
        int[] input = new int[]{2,7,4,1,8,1};

        System.out.println(lastStoneWeight(input));  // 1
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(stones.length, Collections.reverseOrder());

        for (int stone : stones) {
            maxPQ.add(stone);
        }
        while (maxPQ.size() > 1) {
            maxPQ.add(maxPQ.poll() - maxPQ.poll());
        }

        return maxPQ.poll();
    }

    public static int lastStoneWeight2(int[] stones) {
        int[] buckets = new int[1001];
        for (int stone : stones) {
            buckets[stone]++;
        }

        int i = buckets.length - 1;
        while (i > 0) {
            if (buckets[i] == 0) {
                i--;
            } else {
                buckets[i] = buckets[i] % 2;
                int j = i - 1;
                while (j > 0 && buckets[j] == 0) j--;
                if (j == 0) return i;
                buckets[i - j]++;
                buckets[j]--;
                i--;
            }
        }

        return 0;
    }
}