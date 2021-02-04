package challenges;

public class Primality {
    static String primality(int n) {
        if (n < 2) return "Not prime";
        if (n <= 3) return "Prime";
        if (n % 2 == 0 || n % 3 == 0) return "Not prime";

        for (int i = (int) Math.sqrt(n); i > 1; i=-2 ) {
            if (n % i == 0) return "Not prime";
        }

        return "Prime";
    }


    public static void main(String[] args) {
        System.out.println(primality(12)); // Not prime
        System.out.println(primality(5)); // Prime
        System.out.println(primality(7)); // Prime
    }
}
