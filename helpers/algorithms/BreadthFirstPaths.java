package algorithms;

//import edu.princeton.cs.algs4.Graph;
//import edu.princeton.cs.algs4.In;
//import edu.princeton.cs.algs4.StdOut;

public class BreadthFirstPaths {
    private boolean[] marked; // marked[v] = is there an s-v path
    private int[] edgeTo;   // edgeTo[v] = previous edge on shortest s-v path

//    public BreadthFirstPaths()

    /**
     * Unit tests the {@code BreadthFirstPaths} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
//        In in = new In(args[0]);
//        Graph G = new Graph(in);
//        // StdOut.println(G);
//
//        int s = Integer.parseInt(args[1]);
//        edu.princeton.cs.algs4.BreadthFirstPaths bfs = new edu.princeton.cs.algs4.BreadthFirstPaths(G, s);
//
//        for (int v = 0; v < G.V(); v++) {
//            if (bfs.hasPathTo(v)) {
//                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
//                for (int x : bfs.pathTo(v)) {
//                    if (x == s) StdOut.print(x);
//                    else        StdOut.print("-" + x);
//                }
//                StdOut.println();
//            }
//
//            else {
//                StdOut.printf("%d to %d (-):  not connected\n", s, v);
//            }
//        }
    }
}
