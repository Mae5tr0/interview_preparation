package challenges;

public class DavidStaricase {
    // recurstion
    static int stepPerms(int n) {
        int[] memo = new int[n + 1];

        return helper(memo, n);
    }

    static int helper(int[] memo, int pos) {
        if (pos == 1) return 1;
        if (pos == 2) return 2;
        if (pos == 3) return 4;

        if (memo[pos] == 0) {
            memo[pos] = helper(memo, pos - 1) + helper(memo, pos - 2) + helper(memo, pos - 3);
        }
        return memo[pos];
    }

    // dp
    static int stepPerms_dp(int n) {
        int[] memo = new int[Math.max(n + 1, 4)];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(1)); // 1
        System.out.println(stepPerms(3)); // 4
        System.out.println(stepPerms(5)); // 13
        System.out.println(stepPerms(7)); // 44
        System.out.println(stepPerms_dp(1)); // 1
        System.out.println(stepPerms_dp(3)); // 4
        System.out.println(stepPerms_dp(7)); // 44
    }
}
