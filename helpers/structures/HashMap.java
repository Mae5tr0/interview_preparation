package structures;

/**
 *  The {@code HashMap} class represents a symbol table of generic
 *  key-value pairs.
 *  It supports the usual <em>put</em>, <em>get</em>, <em>contains</em>,
 *  <em>delete</em>, <em>size</em>, and <em>is-empty</em> methods.
 *  It also provides a <em>keys</em> method for iterating over all of the keys.
 *  A symbol table implements the <em>associative array</em> abstraction:
 *  when associating a value with a key that is already in the symbol table,
 *  the convention is to replace the old value with the new value.
 *  Unlike {@link java.util.Map}, this class uses the convention that
 *  values cannot be {@code null}—setting the
 *  value associated with a key to {@code null} is equivalent to deleting the key
 *  from the symbol table.
 *  <p>
 *  This implementation uses a separate chaining hash table. It requires that
 *  the key type overrides the {@code equals()} and {@code hashCode()} methods.
 *  The expected time per <em>put</em>, <em>contains</em>, or <em>remove</em>
 *  operation is constant, subject to the uniform hashing assumption.
 *  The <em>size</em>, and <em>is-empty</em> operations take constant time.
 *  Construction takes constant time.
 *
 */
public class HashMap<Key, Value> {
    private static final int INITIAL_CAPACITY = 10;

    private LinkedList<Pair<Key, Value>>[] storage; // array of linked-list symbol tablesd
    private int itemsCount;  // number of key-value pairs

    public HashMap() { this(INITIAL_CAPACITY); }

    public HashMap(int initCapacity) {
        storage = new LinkedList[initCapacity];

        for (int i = 0; i < initCapacity; i++) {
            storage[i] = new LinkedList<>();
        }
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     *
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        return itemsCount;
    }

    /**
     * Returns true if this symbol table is empty.
     *
     * @return {@code true} if this symbol table is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key};
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the specified key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with {@code key} in the symbol table;
     *         {@code null} if no such value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");

        return find(key, storage[hash(key)]);
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  value the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }

        // double table size if average length of list > 5
        if (itemsCount > storage.length * 5) resize(storage.length * 2);
        put(key, value, storage[hash(key)]);
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        LinkedList<Pair<Key, Value>> newList = new LinkedList<>(); // not optimal, required work with internal structure
        for (Pair<Key, Value> item : storage[i]) {
            if (item.getFirst() == key) {
                itemsCount--;
            } else {
                newList.push(item);
            }
        }
        storage[i] = newList;

        // halve table size if average length of list <= 2
        if (storage.length > INITIAL_CAPACITY && itemsCount <= 2 * storage.length) resize(storage.length / 2);
    }

    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     */
    public Iterable<Key> keys() {
        LinkedList<Key> keys = new LinkedList<>();
        for (Pair<Key, Value> item : items()) {
            keys.push(item.getFirst());
        }

        return keys;
    }

    /**
     * Returns all values in the symbol table as an {@code Iterable}.
     * To iterate over all of the values in the hash map
     * use the foreach notation: {@code for (Value value : st.values())}.
     *
     * @return all values in the symbol table
     */
    public Iterable<Value> values() {
        LinkedList<Value> keys = new LinkedList<>();
        for (Pair<Key, Value> item : items()) {
            keys.push(item.getLast());
        }

        return keys;
    }

    private Iterable<Pair<Key, Value>> items() {
        LinkedList<Pair<Key, Value>> items = new LinkedList<>();

        for (int i = 0; i < storage.length; i++) {
            for (Pair<Key, Value> item : storage[i]) {
                items.push(item);
            }
        }

        return items;
    }

    private int hash(Key key) {
        return key.hashCode() % storage.length;
    }

    private void resize(int newSize) {
        HashMap<Key, Value> temp = new HashMap<>(newSize);

        for (Pair<Key, Value> item : items()) {
            temp.put(item.getFirst(), item.getLast());
        }

        storage = temp.storage;
    }

    private void put(Key key, Value value, LinkedList<Pair<Key, Value>> list) {
        for (Pair<Key, Value> el : list) {
            if (el.getFirst() == key) {
                el.setSecond(value);
                return;
            }
        }

        itemsCount++;
        list.push(new Pair<>(key, value));
    }

    private Value find(Key key, LinkedList<Pair<Key, Value>> list) {
        for (Pair<Key, Value> el : list) {
            if (el.getFirst() == key) return el.getLast();
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Pair<Key, Value> item : items()) {
            result.append("  ").append(item.getFirst()).append(" : ").append(item.getLast()).append("\n");
        }
        result.append("}\n");

        return result.toString();
    }

    /**
     * Unit tests the {@code HashMap} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("key", 1);
        map.put("deleted", 2);
        map.put("duplicate", 5);
        map.put("duplicate", 6);

        map.delete("deleted");

        System.out.println(map);
    }
}
