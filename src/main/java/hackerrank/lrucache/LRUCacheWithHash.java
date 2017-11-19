package hackerrank.lrucache;

/**
 * Created by ts250370 on 11/13/17.
 */
public class LRUCacheWithHash {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class PosQ {
        int[] q;
        int front = 0;
        int rear = 0;

        PosQ(int capacity) {
            q = new int[capacity];
        }

        int getLRUPos() {
            return q[front];
        }

        void remove() {
            front++;
        }

        void add(int pos) {
            if (rear < capacity) {
                q[rear] = pos;
                rear++;
            } else {

            }
        }


    }

    class NodeQ {
        int capacity = 0;
        int count = 0;
        Node[] q;

        NodeQ(int capacity) {
            q = new Node[capacity];
            this.capacity = capacity;
        }

        int get(int pos, int x) {
            Node node = q[pos];
            if (node.key == x) {
                return node.val;
            } else {
                while (node.next != null) {
                    node = node.next;
                    if (node.key == x) {
                        return node.val;
                    }
                }
            }
            return -1;
        }

        void add(int pos, Node node, PosQ posQ) {
            if (count < capacity) {
                addWhenThereSpace(pos, node);
            } else {
                addWhenThereIsNoSpace(pos, node, posQ);
                posQ.remove();
            }
            posQ.add(pos);
        }

        private void addWhenThereIsNoSpace(int pos, Node node, PosQ posQ) {
            count--;
            int removeAtPos = posQ.getLRUPos();
            Node lruNode = q[removeAtPos];
            q[removeAtPos] = lruNode.next;

            addWhenThereSpace(pos, node);

        }

        private void addWhenThereSpace(int pos, Node node) {
            if (q[pos] == null) {
                q[pos] = node;
            } else {
                Node current = q[pos];
                while (current.next != null) {
                    current = current.next;
                }
                current.next = node;
            }
            count++;
        }

    }

    int capacity;
    NodeQ nodeQ;
    PosQ posQ;

    /*Inititalize an LRU cache with size N */
    public LRUCacheWithHash(int N) {
        this.capacity = N;
        nodeQ = new NodeQ(capacity);
        posQ = new PosQ(150);
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
        int pos = getHash(x);

        return nodeQ.get(pos, x);
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
        Node newNode = new Node(x, y);
        int pos = getHash(x);

        nodeQ.add(pos, newNode, posQ);
    }

    private int getHash(int key) {
        return (key + 31) % 7;
    }

    public static void main(String[] args) {
        LRUCacheWithHash lruCache = new LRUCacheWithHash(7);
        lruCache.set(1, 2);
        lruCache.set(2, 3);
        lruCache.set(3, 5);
        lruCache.set(4, 5);
        lruCache.set(6, 7);
        lruCache.set(5, 8);
        lruCache.set(92, 1);
        lruCache.set(95, 1);
        lruCache.set(42, 1);
        lruCache.set(72, 1);

        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(1));
    }
}
