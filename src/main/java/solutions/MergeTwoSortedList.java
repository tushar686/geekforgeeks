package solutions;

/**
 * Created by ts250370 on 4/23/18.
 */
public class MergeTwoSortedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        mergeTwoSortedList.createList();
    }

    void createList() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(head1, head2);

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode last = null;

        if(l1 != null && l2 != null ) {
            if (l1.val < l2.val) {
                head = l1;
                last = l1;
                l1 = l1.next;
            } else {
                head = l2;
                last = l2;
                l2 = l2.next;
            }
        }

        while (l1 != null && l2 != null ) {
            if (l1.val < l2.val) {
                last.next = l1;
                last = l1;
                l1 = l1.next;
            } else {
                last.next  = l2;
                last = l2;
                l2 = l2.next;
            }

        }

        if (l1 != null) {
            if (last == null) {
                return l1;
            } else {
                last.next = l1;
            }
        }
        if (l2 != null) {
            if (last == null) {
                return l2;
            } else {
                last.next = l2;
            }
        }


        return head;
    }
}
