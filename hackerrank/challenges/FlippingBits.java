package challenges;

public class FlippingBits {
    static long flippingBits(long n) {
        long p  = 4294967295L;
        return n ^ p;
    }


    public static void main(String[] args) {
        System.out.println(flippingBits(2147483647)); //  2147483648
        System.out.println(flippingBits(1)); //  4294967294
        System.out.println(flippingBits(0)); //  4294967295
    }
}
