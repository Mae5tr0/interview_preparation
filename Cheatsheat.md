# Algorithms

## Quick sort

* Choose base element, divide array on 2 subarrays (less and more)
* Recursively sort subarrays

```java
void sort(Comparable[] a) {
    Arrays.shuffle(a);
    sort(a, 0, a.length - 1);
}

void sort(Comparable[] a, int lo, int hi) {
    // [Optimization] switch to insertion sort for small subarrays
    if (hi <= lo + CUTOFF - 1) {
        Insertion.sort(a, lo, hi);
        return;
    }

    // partitioning
    int j = partition(a, lo, hi);

    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
}

int partition(Comparable[] a, int lo, int hi) {
    int i = lo;
    int j = hi + 1;

    while (true) {
        while (less(a[++i], a[lo])) {
            if (i == hi) break;
        }
        while (less(a[lo], a[--j])) {
            if (j == lo) break;
        }

        if (i >= j) break;
        exch(a, i, j);
    }

    exch(a, lo, j);

    return j;
}

void exch(Object[] a, int i, int j) {
    Object buf = a[i];
    a[i] = a[j];
    a[j] = buf;
}

boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }
```

## Merge sort

* Split array on 2 parts
* Recursively sort splitted arrays
* Merge results

```java
void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
}

void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    // copy to aux[]
    // we can eliminate this operation by change role for aux array in recursive invocation
    // https://algs4.cs.princeton.edu/22mergesort/MergeX.java.html
    for (int k = lo; k <= hi; k++) {
        aux[k] = a[k];
    }

    // merge back to a[]
    int i = lo;
    int j = mid + 1;
    for (int k = lo; k <= hi; k++) {
        if      (i > mid)               a[k] = aux[j++];
        else if (j > hi)                a[k] = aux[i++];
        else if (less(aux[i], aux[j]))  a[k] = aux[i++];
        else                            a[k] = aux[j++];
    }
}

void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    // switch to insertion sort for small subarrays
    if (hi <= lo + CUTOFF - 1) {
        Insertion.sort(a, lo, hi);
        return;
    }

    int mid = (hi - lo) / 2 + lo;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);

    // don't merge already sorted arrays
    if (less(a[mid], a[mid + 1])) return;
    merge(a, aux, lo, mid, hi);
}

boolean less(Comparable v, Comparable w) { return v.compareTo(w) < 0; }
```

## BFS

* Process node, all edges put to queue
* Get first node from queue and recursively repeat it

```java
private boolean[] marked;  // marked[v] = is there an s-v path
private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
private int[] distTo;      // distTo[v] = number of edges shortest s-v path

void bfs(Graph G, int s) {
    Queue<Integer> q = new Queue<Integer>();
    for (int v = 0; v < G.V(); v++)
        distTo[v] = INFINITY;
    distTo[s] = 0;
    marked[s] = true;
    q.enqueue(s);

    while (!q.isEmpty()) {
        int v = q.dequeue();
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                distTo[w] = distTo[v] + 1;
                marked[w] = true;
                q.enqueue(w);
            }
        }
    }
}
```

## DFS

* Process node, recursively process all edges from this node

```java
private int[] edgeTo;      // edgeTo[v] = last edge on path from s to v
private final int s;       // source vertex

void dfs(Digraph G, int v) { 
    marked[v] = true;
    for (int w : G.adj(v)) {
        if (!marked[w]) {
            edgeTo[w] = v;
            dfs(G, w);
        }
    }
}
```

## Binary Search

```java
static int indexOf(int[] a, int key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
        // Key is in a[lo..hi] or not present.
        int mid = lo + (hi - lo) / 2;
        if      (key < a[mid]) hi = mid - 1;
        else if (key > a[mid]) lo = mid + 1;
        else return mid;
    }
    return -1;
}
```

## Union Find

```java
public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        if (n < 0) throw new IllegalArgumentException();

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        validate(p);

        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;
        if (rank[rootP] > rank[rootQ]) {
            parent[rootQ] = rootP;
        } else if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else {
            parent[rootP] = rootQ;
            rank[rootQ]++;
        }
    }
}
```

## Topological

```java
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
}
```

# Structures

## Linked List

```java
static class Node {
    public Node next;
    public Node prev;
    public int value;
}
```

## Graph

```java
class Graph {
    public List<Integer>[] edges;
    public int size;

    public Graph(int size) {
        this.size = size;
        edges = new LinkedList[size + 1];
        for (int i = 1; i <= size; i++) {
            edges[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to) {
        edges[from].add(to);
        edges[to].add(from); // if undirected
    }
}

```

## Tries

## Heap

## Binary Tree

```java
static class Node {
    public Node left;
    public Node right;
    public int value;
}
```

## Binary Search Tree

```java
class BinaryTree {
    public Node root;

    public static class Node {
        public Node left;
        public Node right;        
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public void put(int key) {
        root = put(root, key, null);
    }

    private TreeNode put(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (node.value == key) return node;
        if (key < node.value) {
            node.left = put(node.left, key);
        } else {
            node.right = put(node.right, key);
        }

        return node;
    }
}
```