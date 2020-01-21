package challenges;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindTheRunningMedian {
    public static void main(String[] args) {
        int[] stream = {12, 4, 5, 3, 8, 7};

        System.out.println(Arrays.toString(stream));
        System.out.println(Arrays.toString(runningMedian(stream)));
    }

    static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || lowers.peek() > number) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }

    static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }


    static double[] runningMedian(int[] a) {
        double[] medians = new double[a.length];
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -1 * a.compareTo(b);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();

        for (int i = 0; i < a.length; i++) {
            addNumber(a[i], lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }
}
