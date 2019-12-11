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

    public void setSecond(V value) {
        this.b = value;
    }

    public void setFirst(E value) {
        this.a = value;
    }

    @Override
    public String toString() {
        return "(" + a + ',' + b + ')';
    }
}