package challenges;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FrequencyQueries {
    public static void main(String[] args) {
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new LinkedList<>();
//        HashMap<Integer, Integer> map = new HashMap<>();
//        HashMap<Integer, Integer> freq = new HashMap<>();
//
//        for (List<Integer> query : queries) {
//            Integer command = query.get(0);
//            Integer value = query.get(1);
//            Integer prev = map.getOrDefault(value, 0);
//            Integer next = 0;
//
//            switch (command)
//            {
//                case 1:
//                    freq.put(prev, freq.getOrDefault(prev, 0) - 1);
//                    next = prev + 1;
//                    freq.put(next, freq.getOrDefault(prev, 0) + 1);
//                    map.put(value, next);
//                    break;
//                case 2:
//                    freq.put(prev, freq.getOrDefault(prev, 0) - 1);
//                    next = prev - 1;
//                    freq.put(next, freq.getOrDefault(prev, 0) + 1);
//                    map.put(value, next);
//                    break;
//                case 3:
//                    if (freq.getOrDefault(value, 0) > 0) {
//                        result.add(1);
//                    } else {
//                        result.add(0);
//                    }
//                    break;
//            }
//        }
//
        return result;
    }
}
