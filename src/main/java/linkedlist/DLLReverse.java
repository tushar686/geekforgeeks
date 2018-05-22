package linkedlist;

/**
 * Created by ts250370 on 5/21/18.
 */
public class DLLReverse {

    class Node {
        int val;
        Node next;
        Node prev;

        Node(int val) {
            this.val = val;
        }
    }

    Node createDLL() {
        Node head = new Node(1);

        Node node_2 = push(head, 2);
        Node node_3 = push(node_2, 3);
        Node node_4 = push(node_3, 4);

        return head;
    }

    void displayList(Node head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    Node push(Node prev, int val) {
        Node current = new Node(val);
        prev.next = current;
        current.prev = prev;
        return current;
    }

    public static void main(String[] args) {
        DLLReverse dllReverse = new DLLReverse();

        Node head = dllReverse.createDLL();
        dllReverse.displayList(head);
        dllReverse.displayList(dllReverse.reverseDLL(head));
    }

    private Node reverseDLL(Node head) {

        Node current = head;

        Node temp = current.prev;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            return temp.prev;
        }

        return head;
    }

}
