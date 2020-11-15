package challenges;

public class AlteringCharacters {
    static int alternatingCharacters(String s) {
        int deletions = 0;
        char prev = '1';
        for(char c : s.toCharArray()) {
            if (c == prev) {
                deletions++;
            } else {
                prev = c;
            }
        }

        return deletions;
    }
}
