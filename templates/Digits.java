import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Digits {
    public static void main(String[] args) {
        System.out.println(intToDigits(19));
        System.out.println(intToDigits(745));
    }

    // int to digits
    public static List<Integer> intToDigits(int n) {
        LinkedList<Integer> result = new LinkedList<>();

        while (n / 10 >= 1) {
            result.add(n % 10);
            n = n / 10;
        }

        result.add(n % 10);

        return result;
    }
}

