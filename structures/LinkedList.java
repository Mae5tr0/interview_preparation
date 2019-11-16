package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly-linked list implementation of the {@code List} and {@code Deque}.
 *
 * <p>All of the operations perform as could be expected for a doubly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning or the end, whichever is closer to the specified index.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access a linked list concurrently, and at least
 * one of the threads modifies the list structurally, it <i>must</i> be
 * synchronized externally.  (A structural modification is any operation
 * that adds or deletes one or more elements; merely setting the value of
 * an element is not a structural modification.)  This is typically
 * accomplished by synchronizing on some object that naturally
 * encapsulates the list.
 *
 * @param <E> the type of elements held in this collection
 */
public class LinkedList<E> implements Iterable<E> {
    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    public LinkedList() {
    }

    /**
     * Tells if the list is empty
     *
     * @return {@code true} if this list is empty
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    public void addLast(E e) {
        linkLast(e);
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    public void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        E result = first.item;
        unlinkFirst();

        return result;
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    public E removeLast() {
        return pop();
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getLast() {
        if (isEmpty()) throw new NoSuchElementException();

        return last.item;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    public E getFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        return first.item;
    }

    /**
     * Pushes an element onto the stack represented by this list.  In other
     * words, inserts the element at the front of this list.
     *
     * <p>This method is equivalent to {@link #addFirst}.
     *
     * @param e the element to push
     */
    public void push(E e) {
        linkLast(e);
    }

    /**
     * Pops an element from the stack represented by this list.  In other
     * words, removes and returns the first element of this list.
     *
     * @return the element at the front of this list (which is the top
     *         of the stack represented by this list)
     * @throws NoSuchElementException if this list is empty
     */
    public E pop() {
        if (isEmpty()) throw new NoSuchElementException();

        E result = last.item;
        unlinkLast();

        return result;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        first = last = null;
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * Returns an iterator that iterates over the items in the bag.
     */
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    // an iterator over a linked list
    private class ListIterator implements Iterator<E> {
        private Node<E> current;

        // creates a new iterator
        public ListIterator() {
            current = first;
        }

        // is there a next item in the iterator?
        public boolean hasNext() {
            return current != null;
        }

        // this method is optional in Iterator interface
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // returns the next item in the iterator (and advances the iterator)
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E result = current.item;
            current = current.next;
            return result;
        }
    }

    private void unlinkLast() {
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            first = null;
        }
        size--;
    }

    private void unlinkFirst() {
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            last = null;
        }
        size--;
    }

    private void linkFirst(E item) {
        if (isEmpty()) {
            Node<E> node = new Node<E>(item, null, null);
            first = last = node;
        } else {
            Node<E> node = new Node<E>(item, first, null);
            first.prev = node;
            first = node;
        }

        size++;
    }

    private void linkLast(E item) {
        if (isEmpty()) {
            Node<E> node = new Node<E>(item, null, null);
            first = last = node;
        } else {
            Node<E> node = new Node<E>(item, null, last);
            last.next = node;
            last = node;
        }

        size++;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            result.append(iterator.next().toString());
            if (iterator.hasNext()) result.append(", ");
        }
        result.append("]");

        return result.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        list.push("a");
        list.push("b");
        list.push("c");
        list.pop();
        list.push("d");

        System.out.println("size of list = " + list.size());
        System.out.println(list);
    }
}


