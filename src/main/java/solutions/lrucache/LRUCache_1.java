package solutions.lrucache;

/**
 * Created by ts250370 on 11/13/17.
 */
public class LRUCache_1 {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity = 0;
    int count = 0;
    Node head;
    Node tail;

    /*Inititalize an LRU cache with size N */
    public LRUCache_1(int N) {
        this.capacity = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        Node runner = head;
        Node prevNode = null;

        while (runner != null) {
            if (runner.key == x) {
                if (prevNode == null) {
                    if (head.next != null)
                        head = head.next;
                } else {    //accessed node so put it at the end of lrulist
                    prevNode.next = runner.next;
                    runner.next = null;
                    tail.next = runner;
                    tail = tail.next;
                }
                if (head == null) {
                    head = tail;
                }
                return runner.val;
            }
            prevNode = runner;
            runner = runner.next;
        }
        return -1;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        Node newNode = new Node(x, y);
        int updated = updateExistingKey(x, y);
        if (updated == -1) {
            addToQ(newNode);
            count += 1;
        }
    }

    private int updateExistingKey(int x, int y) {
        Node runner = head;
        Node prevNode = null;

        while (runner != null) {
            if (runner.key == x) {
                if (prevNode != null) {
                    prevNode.next = runner.next;
                } else {
                    head = head.next;
                }
                runner.next = null; //put update node at the end of lruQ
                runner.val = y;
                tail.next = runner;
                tail = tail.next;
                if (head == null) {
                    head = tail;
                }
                return runner.val;
            }
            prevNode = runner;
            runner = runner.next;
        }
        return -1;
    }

    private void addToQ(Node newNode) {
        if (head == null && tail == null) {
            head = tail = newNode;
        } else if (count < capacity) {
            tail.next = newNode;
            tail = tail.next;
        } else if (count >= capacity) {
            head = head.next;
            count -= 1;
            tail.next = newNode;
            tail = tail.next;
            if (head == null) {
                head = tail;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache_1 lruCache = new LRUCache_1(4);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(4, 4);
        lruCache.set(6, 6);
        System.out.println(lruCache.get(1));
        lruCache.set(7, 8);
        System.out.println(lruCache.get(2));
        lruCache.set(8, 8);
    }
}
