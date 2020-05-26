package challenges;

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(new int[]{2, 1, 5, 3, 4}); // 3
        minimumBribes(new int[]{2, 5, 1, 3, 4}); // Too chaotic
        minimumBribes(new int[]{1, 2, 5, 3, 7, 8, 6, 4}); // 7
    }

    static void minimumBribes(int[] q) {
        int bribes = 0;
        for (int i = 0; i < q.length; i++) {
            int pos = i + 1;
            if (q[i] != pos) {
                if (q[i] - pos > 2) {
                    System.out.println("Too chaotic");
                    return;
                }
                for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                    if (q[j] > q[i]) bribes++;
                }
            }
        }

        System.out.println(bribes);
    }
}
