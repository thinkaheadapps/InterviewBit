package interviewbit365daysofcode;

class ListNode {
     public int val;
    public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }

public class ReverseLinkListII {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (B == C) {
            return A;
        }
        ListNode ans = new ListNode(0);
        ListNode leftPtr = ans;
        leftPtr.next = A;
        ListNode rightPtr = A;
        for (int i = 0; i < B - 1; i++) {
            leftPtr = leftPtr.next;
        }
        for (int i = 0; i < C; i++) {
            rightPtr = rightPtr.next;
        }
        ListNode first = leftPtr.next;
        leftPtr.next = null;
        ListNode cur = first;
        ListNode prev = null;
        for (int i = 0; i < C - B + 1; i++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        leftPtr.next = prev;
        first.next = rightPtr;
        return ans.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ReverseLinkListII reverseLinkListII = new ReverseLinkListII();
        ListNode reversedList = reverseLinkListII.reverseBetween(node1, 2, 4);

        // Print the reversed list
        while (reversedList != null) {
            System.out.print(reversedList.val + " ");
            reversedList = reversedList.next;
        }
        System.out.println();
    }
}
