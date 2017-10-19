package linkedlist;

/**
 * Created by ts250370 on 9/9/17.
 */
public class FindNthLastNode {

    class List {
        Node head;
        Node tail;

        class Node {
            int data;
            Node next;

            Node(int d) {
                this.data = d;
            }

            @Override
            public String toString() {
                return String.valueOf(data);
            }
        }

        public void addAtFront(int d) {
            Node front = new Node(d);
            front.next = head;

            if (head == null && tail == null) {
                tail = front;
            }

            head = front;
        }

        public void addAtTail(int d) {
            Node end = new Node(d);

            if (head == null && tail == null) {
                head = end;
            } else {
                tail.next = end;
            }
            tail = end;
        }
    }

    public static void main(String[] args) {
        FindNthLastNode findNthLastNode = new FindNthLastNode();
        FindNthLastNode.List list = findNthLastNode.new List();
        list.addAtFront(4);
        list.addAtFront(2);
        list.addAtFront(3);
        list.addAtFront(5);
        list.addAtFront(6);
        list.addAtFront(7);

        List.Node head = list.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

        List.Node node = findNthLastNode(list, 0);

        System.out.println();
        System.out.println(node);
    }

    private static List.Node findNthLastNode(FindNthLastNode.List list, int n) {

        List.Node p1 = list.head;
        List.Node p2 = list.head;

        if(p2 == null) {
            return null;
        }

        for(int i=0; i<n ; i++) {
            if(p2 == null) { //list size is less than n
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

}
