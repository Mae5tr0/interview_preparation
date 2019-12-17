package chapter_8;

import java.util.ArrayList;

/**
 * Power Set
 *
 * Write a method to return all subsets of a set.
 *
 */
public class Task_4 {

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            set.add(i + i);
        }

        System.out.println(set);

        System.out.println(getSubsets(set));
        System.out.println(getSubsets2(set));
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set) {
        return getSubsets(set, 0);
    }

    private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;

        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<Integer>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            ArrayList<ArrayList<Integer>> subsetsForIndex = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(set.get(index));
                subsetsForIndex.add(newSubset);
            }
            allSubsets.addAll(subsetsForIndex);
        }

        return allSubsets;
    }

    private static ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
        ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
        int max = 1 << set.size();
        for (int k = 0; k < max; k++) {
            ArrayList<Integer> subset = convertIntToSet(k, set);
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private static ArrayList<Integer> convertIntToSet(int k, ArrayList<Integer> set) {
        ArrayList<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int i = k; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }

        return subset;
    }


}