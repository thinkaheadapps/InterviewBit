package interviewbit365daysofcode.LinkedList;


 class ListNode {
    public int val;
    public ListNode next;
     ListNode(int x) { val = x; next = null; }
}

public class SortList {

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode mid = findMid(A);
        ListNode h1 = mid.next;
        mid.next = null;
        ListNode t1 = sortList(A);
        ListNode t2 = sortList(h1);
        ListNode t3 = merge(t1, t2);
        return t3;
    }

    public ListNode merge(ListNode t1, ListNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        ListNode head, t;
        if (t1.val < t2.val) {
            head = t1;
            t = t1;
            t1 = t1.next;
        } else {
            head = t2;
            t = t2;
            t2 = t2.next;
        }
        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                t.next = t1;
                t1 = t1.next;
                t = t.next;
            } else {
                t.next = t2;
                t2 = t2.next;
                t = t.next;
            }
        }
        if (t1 != null) {
            t.next = t1;
        }
        if (t2 != null) {
            t.next = t2;
        }
        return head;
    }

    public ListNode findMid(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // Creating an instance of SortList class
        SortList sorter = new SortList();

        // Sorting the list
        ListNode sortedList = sorter.sortList(head);

        // Printing the sorted list
        System.out.println("Sorted List:");
        while (sortedList != null) {
            System.out.print(sortedList.val + " ");
            sortedList = sortedList.next;
        }
    }

}
