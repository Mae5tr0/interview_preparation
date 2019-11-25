package structures;

public class Pair<E, V> {
    private E a;
    private V b;

    public Pair(E a, V b) {
        this.a = a;
        this.b = b;
    }

    public E getFirst() {
        return a;
    }

    public V getLast() {
        return b;
    }

    @Override
    public String toString() {
        return "(" + a + ',' + b + ')';
    }
}