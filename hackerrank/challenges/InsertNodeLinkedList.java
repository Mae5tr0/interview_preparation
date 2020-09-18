package challenges;

public class InsertNodeLinkedList {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) return head;

        if (position == 0) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = head;
            return newNode;
        } else {
            head.next = insertNodeAtPosition(head.next, data, position - 1);
        }

        return head;
    }
}
