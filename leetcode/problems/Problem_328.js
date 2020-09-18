/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var oddEvenList = function (head) {
    if (head === null) return head;

    var odd = head;
    var even = head.next;
    var evenHead = even;

    while (even !== null && even.next !== null) {
        odd.next = odd.next.next;
        even.next = even.next.next;
        odd = odd.next;
        even = even.next;
    }

    odd.next = evenHead;
    return head;
};


function ListNode(val, next) {
    this.val = (val === undefined ? 0 : val)
    this.next = (next === undefined ? null : next)

    this.toString = function () {
        return `${this.val} -> ${this.next === null ? 'NULL' : this.next.toString()}`;
    }
}


var list = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

oddEvenList(list);

console.log(list.toString());
