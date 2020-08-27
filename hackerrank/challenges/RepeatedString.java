package challenges;

public class RepeatedString {
    public static void main(String[] args) {
        System.out.println(repeatedString("aba", 10 )); // 7
        System.out.println(repeatedString("a", 1000000000 )); // 1000000000
        System.out.println(repeatedString("track", 9 )); // 2
    }

    static long repeatedString(String s, long n) {
        long count = 0;
        char[] sArray = s.toCharArray();

        int aFreq = 0;
        for (char c : sArray) {
            if (c == 'a') aFreq++;
        }

        long f = n / s.length();
        long rest = n % s.length();
        count += aFreq * f;

        for (long i = 0; i < rest; i++) {
            if (sArray[(int) i] == 'a') count++;
        }

        return count;
    }
}
