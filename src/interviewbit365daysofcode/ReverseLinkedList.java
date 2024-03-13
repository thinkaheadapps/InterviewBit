package interviewbit365daysofcode;

public class ReverseLinkedList {

    /*
    https://www.interviewbit.com/problems/reverse-linked-list/
     */

    public ListNode reverseList(ListNode A) {
        ListNode head = A;
        ListNode tmp = head;
        ListNode prev = null;

        if(head == null) {
            return head;
        }

        if(head.next == null) {
            return head;
        }

        while(tmp != null) {
            ListNode x = tmp.next;
            tmp.next = prev;
            prev = tmp;
            tmp = x;
        }

        return prev;
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }


    public static void main(String[] args) {
        // Create a linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Print the original linked list
        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        head = reverseLinkedList.reverseList(head);

        // Print the reversed linked list
        System.out.println("\nReversed Linked List:");
        printList(head);
    }

}
