package linkedlist;

public class LinkedList {
    public static void main(String[] args) {

    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }

        void appendToTail(int data) {
            Node end = new Node(data);

            Node n = this;
            while(n.next != null) { n = n.next; }
            n.next = end;
        }

        Node deleteNode(Node head, int data) {
            Node n = head;
            if(data == n.data) {
                return n.next;
            }

            while(n.next != null) {
                if(data == n.next.data) {
                    n.next = n.next.next;
                    return head;
                }
            }

            return null;
        }
    }
}
