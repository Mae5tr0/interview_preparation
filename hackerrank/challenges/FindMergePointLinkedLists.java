package challenges;

public class FindMergePointLinkedLists {
    static class SinglyLinkedListNode {
        int data;
        SinglyLinkedListNode next;

        SinglyLinkedListNode(int data) {
            this.data = data;
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode currentA = head1;
        SinglyLinkedListNode currentB = head2;

        while (currentA != currentB) {
            if (currentA.next == null) {
                currentA = head2;
            } else {
                currentA = currentA.next;
            }

            if (currentB.next == null) {
                currentB = head1;
            } else {
                currentB = currentB.next;
            }
        }

        return currentB.data;
    }

}
