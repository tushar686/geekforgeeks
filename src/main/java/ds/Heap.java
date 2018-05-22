package ds;

import java.util.Random;

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

        Random random = new Random(50);
        for (int i=0; i<heap.INPUT_SIZE; i++) {
            Node node = heap.new Node(random.nextInt(50) + 1);
            heap.insert(node);
            // heap.heapifyBottomUp(node, heap.count-1);
        }
        for (int i=0; i<heap.count/2; i++) {
            heap.heapifyTopDownForInsertion(i);
        }

        System.out.println(heap.getMin().priority);

        for (int i=0; i<heap.INPUT_SIZE; i++) {
            System.out.print(heap.deleteMin().priority + " ");
        }
        System.out.println();
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
        count++;
    }

    private void heapifyTopDownForInsertion(int currentPos) {
            if (count >= 2*currentPos+1 && count > 2*currentPos+2) {
                int minChildPos = min(2*currentPos+1, 2*currentPos+2);
                if (heap[currentPos].priority > heap[minChildPos].priority) {
                    swap(currentPos, minChildPos);
                    heapifyTopDownForInsertion( (currentPos-1) / 2);
                }
            } else if(2*currentPos + 1 <= count) {
                if (heap[currentPos].priority > heap[2*currentPos + 1].priority) {
                    swap(currentPos, 2*currentPos + 1);
                    heapifyTopDownForInsertion(currentPos-1/2);
                }
            }
            
    }

    private int min(int pos1, int pos2) {
        if (heap[pos1].priority < heap[pos2].priority) {
            return pos1;
        }
        return pos2;
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
