package challenges;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU")); // 1
        System.out.println(countingValleys(12, "DDUUDDUDUUUD")); // 2
    }

//    static int countingValleys(int n, String s) {
//        int valleys = 0;
//        int currentLevel = 0;
//        boolean valley = false;
//        for (Character c : s.toCharArray()) {
//            if (c.equals('U')) currentLevel++;
//            if (c.equals('D')) currentLevel--;
//
//            if (currentLevel < 0 && valley) {
//                // skip
//            } else if (currentLevel < 0) {
//                valley = true;
//                valleys++;
//            } else {
//                valley = false;
//            }
//        }
//
//        return valleys;
//    }

    static int countingValleys(int n, String s) {
        int valleys = 0;
        int currentLevel = 0;
        for (Character c : s.toCharArray()) {
            if (c == 'U') currentLevel++;
            if (c == 'D') currentLevel--;

            if (currentLevel == 0 && c == 'U') {
                valleys++;
            }
        }

        return valleys;
    }
}
