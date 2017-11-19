package solutions.lrucache;

/**
 * Created by ts250370 on 11/13/17.
 */
public class LRUCache {

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
    Node front;
    Node rear;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
        this.capacity = N;
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        Node runner = front;

        while (runner != null) {
            if (runner.key == x) {
                return runner.val;
            }
            runner = runner.next;
        }
        return -1;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        Node newNode = new Node(x, y);
        addToQ(newNode);
        count += 1;
    }

    private void addToQ(Node newNode) {
        if (front == null && rear == null) {
            front = rear = newNode;
        }

        if (count < capacity) {
            rear.next = newNode;
            rear = rear.next;
        }

        if (count >= capacity) {
            front = front.next;
            count -= 1;
            addToQ(newNode);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(1, 2);
        lruCache.set(2, 3);
        lruCache.set(1, 5);
        lruCache.set(4, 5);
        lruCache.set(6, 7);

        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(1));
    }
}
