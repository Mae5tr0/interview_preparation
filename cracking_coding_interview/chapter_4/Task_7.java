package chapter_4;

import algorithms.Topological;
import structures.Digraph;

/**
 * Build Order
 *
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the first project). All of a project's dependencies must be built
 * before the project is. Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error.
 *
 */
public class Task_7 {

    public static void main(String[] args) {
        topological(); // simplified
    }

    public static void topological() {
        Digraph digraph = new Digraph(6);

        char[] projects = {'a', 'b', 'c', 'd', 'e', 'f'};

        digraph.addEdge(0, 3); // (a, d)
        digraph.addEdge(5, 1); // (f, b)
        digraph.addEdge(1, 3); // (b, d)
        digraph.addEdge(5, 0); // (f, a)
        digraph.addEdge(3, 2); // (d, c)

        Topological topological = new Topological(digraph);

        for (int v : topological.order()) {
            System.out.println(projects[v]);
        }
    }


}
