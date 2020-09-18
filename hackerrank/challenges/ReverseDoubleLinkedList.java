package challenges;

public class ReverseDoubleLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        if (head == null) return head;

        DoublyLinkedListNode buf = null;
        buf = head.next;
        head.next = head.prev;
        head.prev = buf;

        if (head.prev != null) return reverse(head.prev);

        return head;
    }
}
