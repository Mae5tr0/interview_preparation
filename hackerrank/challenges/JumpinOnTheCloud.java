package challenges;

public class JumpinOnTheCloud {
    public static void main(String[] args) {
        System.out.println(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0})); // 4
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0})); // 3
        System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0})); // 3
    }

//    static int jumpingOnClouds(int[] c) {
//        if (c == null) throw new IllegalArgumentException();
//
//        int steps = 0;
//        int i = 0;
//        while (i < c.length - 1) {
//            if (c[i] > 0) {
//                i--;
//            } else {
//                i += 2;
//                steps++;
//            }
//        }
//
//        return steps;
//    }

    static int jumpingOnClouds(int[] c) {
        int count = 0;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == 0) i++;
            count++;
        }

        return count;
    }
}
