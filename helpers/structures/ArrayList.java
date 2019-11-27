package structures;

import edu.princeton.cs.algs4.ResizingArrayBag;

import java.util.*;

/**
 * Resizable-array implementation of the <tt>List</tt>.
 *
 * <p>The <tt>size</tt>, <tt>isEmpty</tt>, <tt>get</tt>, <tt>set</tt>,
 * <tt>iterator</tt>, and <tt>listIterator</tt> operations run in constant
 * time.  The <tt>add</tt> operation runs in <i>amortized constant time</i>,
 * that is, adding n elements requires O(n) time.  All of the other operations
 * run in linear time (roughly speaking).  The constant factor is low compared
 * to that for the <tt>LinkedList</tt> implementation.
 *
 * <p>Each <tt>ArrayList</tt> instance has a <i>capacity</i>.  The capacity is
 * the size of the array used to store the elements in the list.  It is always
 * at least as large as the list size.  As elements are added to an ArrayList,
 * its capacity grows automatically.  The details of the growth policy are not
 * specified beyond the fact that adding an element has constant amortized
 * time cost.
 *
 * <p>An application can increase the capacity of an <tt>ArrayList</tt> instance
 * before adding a large number of elements using the <tt>ensureCapacity</tt>
 * operation.  This may reduce the amount of incremental reallocation.
 *
 * <p><strong>Note that this implementation is not synchronized.</strong>
 * If multiple threads access an <tt>ArrayList</tt> instance concurrently,
 * and at least one of the threads modifies the list structurally, it
 * <i>must</i> be synchronized externally.  (A structural modification is
 * any operation that adds or deletes one or more elements, or explicitly
 * resizes the backing array; merely setting the value of an element is not
 * a structural modification.)  This is typically accomplished by
 * synchronizing on some object that naturally encapsulates the list.
 *
 */
public class ArrayList<E> {
//    private static final int DEFAULT_CAPACITY = 10;
//
//    private E[] elements;
//    private int size = 0;
//
//    @SuppressWarnings("unchecked")
//    public ArrayList(int initialCapacity) {
//        elements = (E[]) new Object[initialCapacity];
//    }
//
//    @SuppressWarnings("unchecked")
//    public ArrayList() {
//        elements = (E[]) new Object[DEFAULT_CAPACITY];
//    }
//
//    public ArrayList(Collection<E> c) {
//        this(c.size());
//        for (E el : c) {
//            this.add(el);
//        }
//    }
//
//    /**
//     * Tells if the list is empty
//     *
//     * @return {@code true} if this list is empty
//     */
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    /**
//     * Returns the number of elements in this list.
//     *
//     * @return the number of elements in this list
//     */
//    public int size() {
//        return size;
//    }
//
//    /**
//     * Returns the element at the specified position in this list.
//     *
//     * @param  index index of the element to return
//     * @return the element at the specified position in this list
//     * @throws IndexOutOfBoundsException if index outbound the limits
//     */
//    public E get(int index) {
//        rangeCheck(index);
//
//        return elements[index];
//    }
//
//    /**
//     * Replaces the element at the specified position in this list with
//     * the specified element.
//     *
//     * @param index index of the element to replace
//     * @param element element to be stored at the specified position
//     * @throws IndexOutOfBoundsException if index outbound the limits
//     */
//    public void set(int index, E element) {
//        rangeCheck(index);
//
//        elements[index] = element;
//    }
//
//    /**
//     * Appends the specified element to the end of this list.
//     *
//     * @param e element to be appended to this list
//     */
//    public void add(E e) {
//        if (size == elements.length) resize(2 * elements.length);
//        elements[size++] = e;
//    }
//
//    /**
//     * Removes the element at the specified position in this list.
//     * Shifts any subsequent elements to the left (subtracts one from their
//     * indices).
//     *
//     * @param index the index of the element to be removed
//     * @return the element that was removed from the list
//     * @throws java.util.NoSuchElementException if this array is empty
//     */
//    public E remove(int index) {
//        if (isEmpty()) throw new NoSuchElementException();
//        rangeCheck(index);
//
//        E result = elements[index];
//        elements[index] = null;
//        size--;
//
//        return result;
//    }
//
//    /**
//     * Removes all of the elements from this list.
//     * The list will be empty after this call returns.
//     */
//    @SuppressWarnings("unchecked")
//    public void clear() {
//        elements = (E[]) new Object[size];
//        size = 0;
//    }
//
//    // resize the underlying array holding the elements
//    private void resize(int capacity) {
//        assert capacity >= size;
//
//        elements = java.util.Arrays.copyOf(elements, capacity);
//    }
//
//    /**
//     * Checks if the given index is in range.  If not, throws an appropriate
//     * runtime exception.  This method does *not* check if the index is
//     * negative: It is always used immediately prior to an array access,
//     * which throws an ArrayIndexOutOfBoundsException if index is negative.
//     */
//    private void rangeCheck(int index) {
//        if (index >= size || index < 0)
//            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
//    }
//
//    /**
//     * Constructs an IndexOutOfBoundsException detail message.
//     * Of the many possible refactorings of the error handling code,
//     * this "outlining" performs best with both server and client VMs.
//     */
//    private String outOfBoundsMsg(int index) {
//        return "Index: "+index+", Size: "+size;
//    }
//
//    /**
//     * Returns an iterator that iterates over the items in the bag.
//     */
//    public Iterator<E> iterator() {
//        return new ArrayIterator();
//    }
//
//    private class ArrayIterator implements Iterator<E> {
//        private int i = 0;
//        public boolean hasNext()  { return i < size;                           }
//        public void remove()      { throw new UnsupportedOperationException(); }
//
//        public E next() {
//            if (!hasNext()) throw new NoSuchElementException();
//
//            while (elements[i++] != null || i < size) {
//                return elements[i];
//            }
//
//            return elements[i++];
//        }
//    }
//
//    @Override
//    public String toString() {
//        StringBuilder result = new StringBuilder();
//        result.append("[");
//        Iterator<E> iterator = this.iterator();
//        while (iterator.hasNext()) {
//            Object item = iterator.next();
//            if (item != null) {
//                result.append(item.toString());
//            }
//            if (iterator.hasNext()) result.append(", ");
//        }
//        result.append("]");
//
//        return result.toString();
//    }
//
//    public static void main(String[] args) {
//        ArrayList<String> array = new ArrayList<>();
//
//        array.add("a");
//        array.add("b");
//        array.add("c");
//        array.remove(1);
//        array.add("d");
//
//        System.out.println("array size = " + array.size());
//        System.out.println(array);
//    }
}


