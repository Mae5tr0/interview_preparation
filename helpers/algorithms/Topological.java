package algorithms;

import structures.Digraph;
import structures.LinkedList;

public class Topological {
    private LinkedList<Integer> order;

    private boolean[] marked;

    // without cycle detection
    public Topological(Digraph digraph) {
        marked = new boolean[digraph.V()];
        order = new LinkedList<>();

        for (int i = 0; i < digraph.V(); i++) {
            if (!marked[i]) dfs(digraph, i);
        }
    }

    private void dfs(Digraph digraph, int v) {
        marked[v] = true;
        for (int w : digraph.adj(v)) {
            if (!marked[w]) dfs(digraph, w);
        }
        order.enqueue(v);
    }

    public Iterable<Integer> order() { return order; }

    public static void main(String[] args) {
        Digraph digraph = new Digraph(7);

        digraph.addEdge(0, 5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(3, 6);
        digraph.addEdge(3, 5);
        digraph.addEdge(3, 4);
        digraph.addEdge(5, 2);
        digraph.addEdge(6, 4);
        digraph.addEdge(6, 0);
        digraph.addEdge(3, 2);
        digraph.addEdge(1, 4);

        System.out.println();

        Topological topological = new Topological(digraph);
        for (int v : topological.order()) {
            System.out.println(v);
        }
    }
}
