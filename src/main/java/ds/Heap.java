package ds;

/**
 * Created by ts250370 on 8/19/17.
 */

public class Heap {
    public class Node {
        public double priority;
        public Object data;

        public Node(int priority) {
            this.priority = priority;
        }
        
        public Node(int priority, Object data) {
            this.priority = priority;
            this.data = data;
        }
    }

    Node[] heap;
    int INPUT_SIZE;
    int count = 0;

    public Heap() {
        this.INPUT_SIZE = 10;
        this.heap = new Node[INPUT_SIZE];
    }

    public Heap(int size) {
        this.heap = new Node[size];
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        heap.insert(heap.new Node(18));
        heap.insert(heap.new Node(16));
        heap.insert(heap.new Node(15));
        heap.insert(heap.new Node(17));
        heap.insert(heap.new Node(24));
        heap.insert(heap.new Node(19));
        heap.insert(heap.new Node(29));
        heap.insert(heap.new Node(27));
        heap.insert(heap.new Node(26));
        heap.insert(heap.new Node(30));
        System.out.println(heap.getMin());

        for (int i=0; i<heap.INPUT_SIZE; i++) {
            System.out.print(heap.deleteMin().priority + " ");
            
        }
    }

    public Node getMin() {
        return heap[0];
    }

    public Node deleteMin() {
        count--;
        Node min = heap[0];

        heap[0] = heap[count];
        heapifyTopDown(0);

        return min;
    }

    private void heapifyTopDown(int pos) {
        if (pos < count/2 && heap[pos].priority > Math.min(heap[2*pos + 1].priority, heap[2*pos + 2].priority)) {
            if (heap[2*pos + 1].priority < heap[2*pos + 2].priority) {
                swap(pos, 2*pos + 1);
                heapifyTopDown(2*pos + 1);
            } else {
                swap(pos, 2*pos + 2);
                heapifyTopDown(2*pos + 2);
            }
        }
    }

    public void insert(Node node) {
        heap[count] = node;
        heapifyBottomUp(node, count);
        count++;
    }

    private void heapifyBottomUp(Node node, int pos) {
        heap[pos] = node;
        int root = (pos-1)/2;

        if (heap[root].priority > node.priority) {
            swap(root, pos);
            heapifyBottomUp(heap[root], root);
        }

    }

    private void swap(int root, int count) {
        Node temp = heap[root];
        heap[root] = heap[count];
        heap[count] = temp;    
    }
}
