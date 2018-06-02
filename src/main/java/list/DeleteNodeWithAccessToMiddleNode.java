package list;

/**
 * Created by ts250370 on 9/9/17.
 */
public class DeleteNodeWithAccessToMiddleNode {

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
        DeleteNodeWithAccessToMiddleNode findNthLastNode = new DeleteNodeWithAccessToMiddleNode();
        DeleteNodeWithAccessToMiddleNode.List list = findNthLastNode.new List();
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

        int j = 0;
        head = list.head;
        while (j < 5) {
            head = head.next;
            j += 1;
        }

        System.out.println();
        System.out.println(head.data);
        DeleteNodeWithAccessToMiddleNode(head);

        System.out.println();
        head = list.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static void DeleteNodeWithAccessToMiddleNode(List.Node node) {
        List.Node prev = node;

        while (node.next != null) {
            node.data = node.next.data;
            prev = node;
            node = node.next;
        }

        node.data = -1;
        prev.next = null;
        prev = null;
    }

}
