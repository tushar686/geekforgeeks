package list;

/**
 * Created by ts250370 on 9/9/17.
 */
public class PrintCircularNode {

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

        public void addExistingNodeAtEnd(Node node) {
            if (head == null && tail == null) {
                head = node;
            } else {
                tail.next = node;
            }
            tail = node;
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
        PrintCircularNode printCircularNode = new PrintCircularNode();
        PrintCircularNode.List list = printCircularNode.new List();

        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        list.addAtTail(6);
        list.addAtTail(7);
        list.addExistingNodeAtEnd(list.head.next.next.next);


        System.out.println(findCircularNode(list));
    }

    private static List.Node findCircularNode(List list) {
        List.Node n1 = list.head;
        List.Node n2 = list.head;

        while (n2.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;

            if (n1 == n2) {
                break;
            }
        }

        n1 = list.head;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n2;
    }

}
