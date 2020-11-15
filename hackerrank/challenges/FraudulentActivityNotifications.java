package challenges;

import java.util.Arrays;

public class FraudulentActivityNotifications {
    // bruteforce
//    static int activityNotifications(int[] expenditure, int d) {
//        if (d >= expenditure.length) return -1; // Raise error
//
//        int[] window = new int[d];
//        int notification = 0;
//        for (int i = d; i < expenditure.length; i++) {
//            System.arraycopy(expenditure, i - d, window, 0, d);
//            Arrays.sort(window);
//            double median = window.length % 2 == 0 ? (double) (window[window.length / 2] + window[window.length / 2 - 1]) / 2 : window[window.length / 2];
//            if (expenditure[i] >= median * 2) notification++;
//        }
//
//        return notification;
//    }

    static int activityNotifications(int[] expenditure, int d) {
        int[] data = new int[201];
        for (int i = 0; i < d; i++) {
            data[expenditure[i]]++;
        }

        int notifications = 0;
        for (int i = d; i < expenditure.length; i++) {
            double median = calcMedian(d, data);

            if (expenditure[i] >= median * 2) notifications++;
            data[expenditure[i]]++;
            data[expenditure[i - d]]--;
        }

        return notifications;
    }

    static double calcMedian(int d, int[] data) {
        double median = 0;
        if (d % 2 == 0) {
            int m1 = -1;
            int m2 = -1;
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (m1 == -1 && count >= d/2) {
                    m1 = j;
                }
                if (count >= d/2 + 1) {
                    m2 = j;
                    break;
                }
            }
            median = (m1 + m2) / 2.0;
        } else {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                count += data[j];
                if (count > d/2) {
                    median = j;
                    break;
                }
            }
        }
        return median;
    }

    public static void main(String[] args) {
        System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5)); //2
        System.out.println(activityNotifications(new int[]{1, 2, 3, 4, 4}, 4)); // 0
    }
}
