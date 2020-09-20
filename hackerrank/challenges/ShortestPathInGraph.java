package challenges;

import java.util.*;

public class ShortestPathInGraph {
    public static class Graph {
        private static int EDGE_WEIGHT = 6;
        private List<Integer>[] edges;
        private int size;

        private class Pair {
            int node;
            int distance;

            public Pair(int node, int distance) {
                this.node = node;
                this.distance = distance;
            }
        }

        public Graph(int size) {
            this.size = size;
            edges = new LinkedList[size + 1];
            for (int i = 1; i <= size; i++) {
                edges[i] = new LinkedList<>();
            }
        }

        public void addEdge(int first, int second) {
            edges[first].add(second);
            edges[second].add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            boolean[] visited = new boolean[size + 1];
            Queue<Pair> queue = new LinkedList<>();
            int[] distances = new int[size + 1];
            Arrays.fill(distances, -1);

            for (Integer nodeTo : edges[startId]) {
                queue.add(new Pair(nodeTo, EDGE_WEIGHT));
            }
            visited[startId] = true;
            distances[startId] = 0;

            while (!queue.isEmpty()) {
                Pair connectedNode = queue.poll();
                int connectedNodeId = connectedNode.node;
                if (visited[connectedNodeId]) continue;
                visited[connectedNodeId] = true;
                distances[connectedNodeId] = connectedNode.distance;
                for (Integer nodeTo : edges[connectedNodeId]) {
                    queue.add(new Pair(nodeTo, connectedNode.distance + EDGE_WEIGHT));
                }
            }

            return distances;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 5);
        System.out.println(Arrays.toString(graph.shortestReach(1))); // [-1, 0, 6, 12, 18, 6, -1]
    }
}
