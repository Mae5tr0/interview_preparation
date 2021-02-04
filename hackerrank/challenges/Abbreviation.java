package challenges;

public class Abbreviation {
    static String abbreviation(String a, String b) {
        char[] charsA = a.toCharArray();
        int posA = 0;

        for (char c : b.toCharArray()) {
            if (posA >= charsA.length - 1) return "NO";

            while (posA < charsA.length) {
                if (c == Character.toUpperCase(charsA[posA])) {
                    posA++;
                    break;
                }
                posA++;
            }
        }

        return "YES";
    }


    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC")); // YES
        System.out.println(abbreviation("AbCdE", "AFE")); // NO
        System.out.println(abbreviation("beFgH", "EFG")); // NO
        System.out.println(abbreviation("beFgH", "EFH")); // YES
    }
}
