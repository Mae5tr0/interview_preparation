package chapter_4;

import structures.Digraph;
import structures.LinkedList;

/**
 * Route Between Nodes
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 */
public class Task_1 {
    public static void main(String[] args) {
        int verticesCount = 8;
        Digraph digraph = new Digraph(verticesCount);

        digraph.addEdge(1, 0);
        digraph.addEdge(1, 2);
        digraph.addEdge(1, 4);
        digraph.addEdge(2, 3);
        digraph.addEdge(3, 5);
        digraph.addEdge(5, 6);
        digraph.addEdge(6, 2);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 7);

        LinkedList<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[verticesCount];
        int[] edgeTo = new int[verticesCount];

        // find route from 1 to 7 (implementing BFS with immediately stop, when route is found
        // should be 1 -> 2 -> 3 -> 5 -> 6 -> 7
        int from = 1;
        int to = 7;
        // init process
        marked[from] = true;
        q.enqueue(from);

        // start processing
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : digraph.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    if (w == to) break;
                    q.enqueue(w);
                }
            }
        }

        // print route
        // also we can implement external BSF with nice API, like hasPathTo, distanceTo and etc,
        // but for now just assume that we know, that path exists
        LinkedList<Integer> path = new LinkedList<>();
        int currentVertice = to;
        while (currentVertice != from) {
            path.addFirst(currentVertice);
            currentVertice = edgeTo[currentVertice];
        }
        path.addFirst(from);

        StringBuilder result = new StringBuilder();
        for (int v : path) {
            result.append(v).append(" -> ");
        }
        System.out.println("Founded path: " + result.substring(0, result.length() - 4));
    }
}
