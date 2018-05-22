package trees.binary;

/**
 * Created by ts250370 on 8/19/17.
 */
public class HuffmanHeap {
    int INPUT_SIZE = 30;
    int count = 0;
    Tree [] heap = new Tree[INPUT_SIZE];

    public static void main(String[] args) {
        HuffmanHeap heap = new HuffmanHeap();
    }

    public Tree getMin() {
        return heap[0];
    }

    public Tree deleteMin() {
        count--;
        Tree min = heap[0];

        if (count > 0) {
            heap[0] = heap[count];
            heapifyTopDown(0);
        } else {
            heap[0] = null;
        }

        return min;
    }

    private void heapifyTopDown(int pos) {
        Tree child_1 = heap[2*pos + 1];
        Tree child_2 = heap[2*pos + 2];
        int priority_1 = child_1 == null ? Integer.MAX_VALUE : child_1.root.key;
        int priority_2 = child_2 == null ? Integer.MAX_VALUE : child_2.root.key;


        if (pos < count/2 && (heap[pos] != null && heap[pos].root.key > Math.min(priority_1, priority_2)) ) {
            if (priority_1 < priority_2) { 
                swap(pos, 2*pos + 1);
                heapifyTopDown(2*pos + 1);
            } else {
                swap(pos, 2*pos + 2);
                heapifyTopDown(2*pos + 2);
            }
        }
    }

    public void insert(Tree newTree) {
        heap[count] = newTree;
        heapifyBottomUp(newTree, count);
        count++;
    }

    private void heapifyBottomUp(Tree newTree, int pos) {
        heap[pos] = newTree;
        int root = (pos-1)/2;
        if (heap[root].root.key > newTree.root.key) {
            swap(root, pos);
            heapifyBottomUp(heap[root], root);
        }

    }

    private void swap(int root, int count) {
        Tree temp = heap[root];
        heap[root] = heap[count];
        heap[count] = temp;    
    }
}
