package amazon;

import java.util.*;

public class Solution_2 {

    public static void main(String[] args) {
        List<String> reviews = new LinkedList<String>(Arrays.asList(
            "newshop is providing good services int the city",
            "everyone should use newshop",
            "best services by newshop",
            "fashionbeats has great servcies in the city",
            "I am proud to have fashionbeats",
            "mymarket has awesome services",
            "Thanks Newshop for the quick delivery"
        ));

        Solution_2 solution_2 = new Solution_2();
        List<String> result = solution_2.topNCompetitors(
                6,
                2,
                new LinkedList<>(Arrays.asList("newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular")),
                6,
                reviews
        );

        System.out.println(result);
    }


    ArrayList<String> topNCompetitors(int numCompetitors,
                                      int topNCompetitors,
                                      List<String> competitors,
                                      int numReviews,
                                      List<String> reviews) {
        PriorityQueue<Competitor> topCompetitors = new PriorityQueue<>(topNCompetitors, competitorComparator);

        // build frequence table
        HashMap<String, Integer> freqTable = new HashMap<>();
        for (String review : reviews) {
            for (String word : review.toLowerCase().split(" ")) {
                int freq = freqTable.getOrDefault(word, 0);
                freqTable.put(word, freq + 1);
            }
        }

        System.out.println(freqTable);

        // build top N competitors
        for (String competitor : competitors) {
            topCompetitors.add(new Competitor(competitor, freqTable.getOrDefault(competitor, 0)));
        }

        System.out.println(competitors);


        // build result
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < topNCompetitors; i++) {
            Competitor competitor = topCompetitors.poll();
            if (competitor != null) { result.add(competitor.name); }
        }

        return result;
    }

    public static Comparator<Competitor> competitorComparator = new Comparator<Competitor>(){
        @Override
        public int compare(Competitor c1, Competitor c2) {
            if (c1.reviews != c2.reviews) return c2.reviews - c1.reviews;

            return c1.name.compareTo(c2.name);
        }
    };

    class Competitor {
        public String name;
        public int reviews;

        Competitor(String name, int reviews) {
            this.name = name;
            this.reviews = reviews;
        }
    }
}
