package challenges;

public class InsertNodeSortedDoubleLinkedList {
    static class DoublyLinkedListNode {
        int data;
        DoublyLinkedListNode next;
        DoublyLinkedListNode prev;

        DoublyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.prev = head;
            return newNode;
        }

        if (head.data > data) {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
            newNode.next = head;
            newNode.prev = head.prev;
            return newNode;
        } else {
            head.next = sortedInsert(head.next, data);
        }

        return head;
    }
}
