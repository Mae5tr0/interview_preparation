package challenges;

public class FibonacciNumbers {
    // recursive
    public static int fibonacci(int n) {
        if (n < 2) return n;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // iterate
    public static int fibonacci_i(int n) {
        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return prev + curr;
    }
}
