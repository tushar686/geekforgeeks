package linkedlist;

import java.util.Scanner;

/**
 * Created by ts250370 on 7/24/17.
 */
public class LinkedList {
    Node head;
    Node tail;
    private int size = -1;

    class Node {
        Object item;
        Node next;

        public Node(Object item) {
            this.item = item;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList linkedList = new LinkedList();

        int read = sc.nextInt();
        while(read != 0) {
            linkedList.insertIntoList(read, false);
            read = sc.nextInt();
        }

        linkedList.print();
    }

    public void insertAtFrontOfList(Object item) {
        insertIntoList(item, true);
    }

    public void insertAtEndOfList(Object item) {
        insertIntoList(item, false);
    }

    private void insertIntoList(Object item, boolean insertAtStart) {
        size++;
        if(this.head == null) {
            this.head = new Node(item);
            this.tail = this.head;
        } else {
            Node node = new Node(item);
            if (insertAtStart) {
                node.next = this.head;
                this.head = node;
            } else {
                this.tail.next = node;
                this.tail = node;
            }
        }
    }

    public Object getAt(int index) {
        if(index >= size() || index < 0) {
            return null;
        }

        int i = 0;
        Node current = this.head;
        while(current != null && i != index) {
            current = current.next;
            i++;
        }
        return current.item;
    }

    public Object find(Object key) {
        Node current = this.head;
        while(current != null && current.equals(key)) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return  size+1;
    }

    public void print() {
        printList(this.head);
    }

    private void printList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.item + "->");
        printList(node.next);
    }
}
