package challenges;

public class Coins {
    static int change(int total) {
        int[] buf = new int[total + 1];
        return helper(total, buf);
    }

    public static int helper(int left, int[] buf) {
        if (left < 0) return 0;
        if (left == 0) return 1;
        if (buf[left] > 0) return buf[left];

        int result = helper(left - 1, buf) + helper(left - 3, buf) + helper(left - 5, buf) + helper(left - 10, buf);
        buf[left] = result;

        return result ;
    }

    public static void main(String[] args) {
        System.out.println(change(3)); // 2
        System.out.println(change(5)); // 6
        System.out.println(change(6)); // 8
    }
}
