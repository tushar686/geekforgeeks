package linkedlist;

/**
 * Created by ts250370 on 9/9/17.
 */
public class FindDuplicateInList {

    class List {
        Node head;
        Node tail;

        class Node {
            int data;
            Node next;

            Node(int d) {
                this.data = d;
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
        FindDuplicateInList findDuplicateInList = new FindDuplicateInList();
        FindDuplicateInList.List list = findDuplicateInList.new List();
        list.addAtFront(4);
        list.addAtFront(2);
        list.addAtFront(3);
        list.addAtFront(5);
        list.addAtFront(6);
        list.addAtFront(5);

        List.Node head = list.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

//        findDuplicates(list);
        findDuplicates_1(list);

        System.out.println();
        head = list.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    private static void findDuplicates(FindDuplicateInList.List list) {

        List.Node head = list.head;
        while (head != null) {
            List.Node runner = list.head;
            while (runner != null) {
                if(head != runner) {
                    if(head.data == runner.data) {
                        if (runner.next != null) {
                            runner.next = runner.next.next;
                        }
                    }
                }
                runner = runner.next;
            }
            head = head.next;
        }

    }

    private static void findDuplicates_1(List list) {

        List.Node prev = list.head;
        List.Node current = list.head.next;

        while (current != null) {

            List.Node runner = list.head;
            while (runner != current) {
                if(runner.data == current.data ) {
                    prev.next = current.next;
                    break;
                }
                runner = runner.next;
            }

            prev = current;
            current = current.next;
        }

    }
}
